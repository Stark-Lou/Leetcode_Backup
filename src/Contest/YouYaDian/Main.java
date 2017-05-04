package Contest.YouYaDian;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Lou on 2017/3/23.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int from = in.nextInt();
        int to = in.nextInt();
        //每个石块，下标代表序号，值代表到达该石块最小步数
        int[] stones = new int[to-from+1];
        //初始化最小步数为最大值to
        for(int i=0;i<stones.length;i++){
            stones[i]=to;
        }
        stones[0] = 0;

        for(int i=0;i<to-from;i++){
            //不可到达点
            if(stones[i] == to)
                continue;
            LinkedList<Integer> list = calculateDiv(from+i,to);
            int size = list.size();
            for(int j=0;j<size;j++){
                int idx = list.pop() + i;
                if(idx<stones.length) {
                    stones[idx] = Math.min(stones[idx], stones[i] + 1);
                    if (idx == to - from) {
                        System.out.println(stones[idx]);
                        return;
                    }
                }
//                System.out.println("update:" + (idx+from) + " value:" + stones[idx]);
            }

        }
        if(stones[to-from] != to){
            System.out.println(stones[to-from]);
        }
        else System.out.println("-1");
    }

    private static LinkedList<Integer> calculateDiv(int num,int max) {
        LinkedList list = new LinkedList();
        for(int i = (int) Math.sqrt(num); i>1; i--){
            if(num%i==0&&(i+num)<=max) {
                list.add(i);
                if(i*i != num) {
                    list.add(num / i);
                }
            }
        }
        return list;
    }


    public void YouYaDian(){
        Scanner in = new Scanner(System.in);
        int r2 = in.nextInt();
        int r = (int) Math.sqrt(r2);

        int count = 0;
        //坐标轴上的点
        if(r*r == r2)
            count=count+4;
        for(int i=1;i<r+1;i++)
            for(int j=r+1;j+i>r+1&&i<=j;j--) {
                System.out.println(i + " " + j);
                if (i * i + j * j == r2) {
                    //x=+-y上的点
                    if (i == j)
                        count += 4;
                    else
                        count += 8;

                }
            }
        System.out.println(count);
    }
}

