package contest.wangyi;

import java.util.Scanner;

public class Main05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine();
        int n = content.length();
        int[] results = new int[n - 2];
        results[1] = 1;
        int sum = 1;
        for (int i = 2; i < results.length; i++) {
            results[i] = sum + 1;
            sum += results[i];
        }
        System.out.println(results[n - 3] - 1);
    }

}
