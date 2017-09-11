package contest.tel;

import java.util.Scanner;

/**
 * Created by Lou on 2017/3/25.
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isHappyNum(i)) {
                count += i;
            }
        }
        System.out.println(count);
    }

    private static boolean isHappyNum(int n) {
        int sum = n;
        while (true) {
            sum = getSum(sum);
            if (sum == 4) {
                break;
            }
            if (sum == 1) {
                return true;
            }
        }
        return false;
    }

    private static int getSum(int n) {
        int sum = 0;
        int x;
        while (n != 0) {
            x = n % 10;
            n = n / 10;
            sum += x * x;
        }
        return sum;
    }

}
