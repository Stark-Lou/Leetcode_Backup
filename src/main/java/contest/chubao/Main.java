package contest.chubao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int idx = 0;
        while (idx < n) {
            idx++;
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println("Case " + idx + ": " + sumLongestVal(start, end));
        }
    }

    private static int sumLongestVal(int start, int end) {
        int target = 0;
        int i = 0;
        while (target <= end) {
            int val = target + (int) Math.pow(2, i);
            System.out.println(val);
            if (val > end) {
                return target;
            }
            if (val == end) {
                return val;
            }
            target = val;
            i++;
        }

        return target;
    }
}
