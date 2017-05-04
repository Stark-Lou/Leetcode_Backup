package Contest.YouYaDian.HuiWenXuLie;

import java.util.Scanner;

/**
 * Created by Lou on 2017/3/23.
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] content = new int[len];
        int i=0;
        while (in.hasNextInt()) {
            content[i] = in.nextInt();
            if(i==len-1){
                //System.out.println("数组初始化完毕！");
                break;
            }
            i++;
        }
        int leftIdx = 0;
        int rightIdx = len-1;
        int count = 0;
        while(rightIdx - leftIdx > 1){
            //对应位置不相等时，进行合并处理
            while(content[rightIdx] != content[leftIdx]){
                //System.out.println("合并处理中...");
                //右值大
                if(content[rightIdx] > content[leftIdx]){
                    content[leftIdx+1] += content[leftIdx];
                    leftIdx++;
                    count++;
                }
                //右值小
                if(content[rightIdx] < content[leftIdx]){
                    content[rightIdx - 1] += content[rightIdx];
                    rightIdx--;
                    count++;
                }
            }
            rightIdx--;
            leftIdx++;
        }
        System.out.println(count);
    }
}
