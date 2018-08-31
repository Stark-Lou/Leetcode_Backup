package contest.meituan;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int[] money = {1, 5, 10, 20, 50, 100};
        System.out.println(dp(sum, money));

    }

    public static long dp(int sum, int[] money) {
        int len = money.length;
        long[][] dp = new long[len + 1][sum + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = 0;
                for (int k = 0; k <= j / money[i - 1]; k++) {
                    dp[i][j] += dp[i - 1][j - k * money[i - 1]];
                }
            }
        }

        return dp[len][sum];
    }
}
