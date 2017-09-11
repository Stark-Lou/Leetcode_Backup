package contest.jd;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String content = in.nextLine();
        char[] chars = content.toCharArray();
        int count = 1;
        int partCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                partCount++;
            } else if (chars[i] == ')') {
                if (partCount == 0) {
                    continue;
                }
                count *= factorial(partCount);
                partCount = 0;
            }
        }
        System.out.println(count);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}