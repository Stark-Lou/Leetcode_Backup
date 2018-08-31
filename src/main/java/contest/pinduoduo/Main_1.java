package contest.pinduoduo;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(count(n, k));
    }

    public static int count(int n, int k) {
        int count = 0;
        for (int y = 2; y <= n; y++) {
            for (int j = k; j <= n - 1; j++) {
                for (int i = (n - j) / y; i >= 0; i--) {
                    int result = i * y + j;
                    if (result <= n) {
                        if (result % y < k) {
                            break;
                        }
                        if (i > 0) {
                            count += i + 1;
                            break;
                        } else {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
