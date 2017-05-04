package Contest.YouYaDian.HuiWenXuLie;

import java.util.Scanner;

/**
 * Created by Lou on 2017/3/24.
 */
public class DarkString {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        if(len < 1)
            System.out.println(0);
        else if(len == 1)
            System.out.println(3);
        else if(len == 2)
            System.out.println(9);
        else{
            ABC abc = new ABC(len);
            int i = 1;      //初始状态即为黑暗字符
            while(abc.numOfC!=len){
                i++;
                abc.nextDarkString(0);
//                System.out.println(i);
                abc.print();
                System.out.println();
            }
            System.out.println(i);
        }
    }
    public static class ABC{
        short[] content;    //内容
        int numOfC;         //C的数量
        public ABC(int len){
            content = new short[len];   //初始化，用 0 1 2分别代表 A B C
            while(--len>=0){
                content[len] = 0;
            }
            numOfC = 0;
        }
        public void nextDarkString(int idx){
            if(idx<0) idx=0;
            int carry=1;
            while(carry==1&&numOfC<content.length){
                content[idx]+=1;
                if(content[idx]==3){    //进一位
                    content[idx]=0;
                    carry=1;
                    numOfC--;
                }else {
                    if(content[idx]==2)     //统计C的数量
                        numOfC++;
                    carry = 0;
                    //如果不是黑暗字符，则继续寻找
                    if(!darkStringExist(idx)){
                        nextDarkString(idx-2);
                    }
                    if(idx>=1&&!darkStringExist(idx-1)){
                        nextDarkString(idx);
                    }
//                    if(idx<content.length-3&&!darkStringExist(idx+1)){
//                        nextDarkString(idx);
//                        idx+=2;
//                    }
                }
                idx++;
            }
        }
        //是否为黑暗字符（不存在连续的A B C为黑暗字符
        private boolean darkStringExist(int idx) {
            int len = content.length;
            if(idx>=len-3){
                if(content[len-1]+content[len-2]+content[len-3]==3&&content[len-1]!=content[len-2])
                    return false;
            }else if(content[idx+2]+content[idx]+content[idx+1]==3&&content[idx+1]!=content[idx])
                return false;
            return true;
        }
        public void print(){
            for(short i:content){
                System.out.print(i + ",");
            }
        }
    }
}
