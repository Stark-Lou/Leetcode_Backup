package contest.tel;

import java.util.Scanner;

/**
 * Created by Lou on 2017/3/25.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbs = new int[n];
        int sum = 0;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            numbs[i] = in.nextInt();
            sum += numbs[i];
            if (numbs[i] < minVal) {
                minVal = numbs[i];
            }
        }
        if (minVal < 0) {
            sum -= n * minVal;
            for (int i = 0; i < n; i++) {
                numbs[i] -= minVal;
            }
        }
        System.out.println(dp(numbs, sum));
    }

    static int dp(int num[], int sum) {
        int i, j;
        int n = num.length / 2;


        boolean dp[][] = new boolean[num.length + 1][sum / 2 + 1];
        for (i = 0; i < num.length; i++)
            for (j = 0; j < sum / 2 + 1; j++)
                dp[i][j] = false;

        dp[0][0] = true;
        for (int k = 0; k < 2 * n; k++) {
            for (i = k > n ? n : k; i >= 1; i--) {
                for (j = 0; j <= sum / 2; j++) {
                    if (j >= num[k] && dp[i - 1][j - num[k]])
                        dp[i][j] = true;
                }
            }
        }
        for (j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                return Math.abs(2 * j - sum);
            }
        }
        return -1;
    }
}
