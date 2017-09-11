package contest.wangyi;

import java.util.Scanner;

public class Main04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbs = sc.nextInt();
        int n;
        int count;
        int val;
        for (int i = 0; i < numbs; i++) {
            n = sc.nextInt();
            count = 0;
            for (int j = 0; j < n; j++) {
                val = sc.nextInt();
                if (val % 4 == 0) {
                    count++;
                } else if (val % 2 != 0) {
                    count--;
                }

            }
            if (count >= 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }

}
