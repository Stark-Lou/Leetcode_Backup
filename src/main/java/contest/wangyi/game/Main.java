package contest.wangyi.game;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();

        int spendCount = 0;
        while (start != end) {
            if (start < end) {
//                if(end/start < 2){
//                    spendCount += x * (end - start)/2;
////                    System.out.println("a+" + x * (end - start)/2);
//                    break;
//                }
                //消耗y的钱如果不如换成消耗x的划算时
                if (start * 2 < (2 * y / x + start)) {
                    start += 2;
                    spendCount += x;
//                    System.out.println("b+2");
                } else {
                    start *= 2;
                    spendCount += y;
//                    System.out.println("c*2");
                }
            } else {
                spendCount += z * (start - end) / 2;
                System.out.println(spendCount);
                break;
            }
        }
        System.out.println(spendCount);

    }

}
