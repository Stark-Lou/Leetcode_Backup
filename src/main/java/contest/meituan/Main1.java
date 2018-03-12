package contest.meituan;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Lou on 2017/8/31.
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbs = new int[N];
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            numbs[i] = sc.nextInt();
            if (numbs[i] % 7 == 0) {
                set.add(i);
            }
        }
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < N; i++) {         //在前
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (set.contains(i) && set.contains(j)) {
                    count++;
                    continue;
                }
                content.append(numbs[i]);
                content.append(numbs[j]);
                if (content.length() >= 10) {
                    if (is7ber(content.toString(), 0)) {
                        count++;
                    }
                } else if (Integer.valueOf(content.toString()) % 7 == 0) {
                    count++;
                }
                content.delete(0, content.length());
            }
        }
        System.out.println(count);
    }

    public static boolean is7ber(String s, int subVal) {
        if (s.length() >= 3) {
            int lastNum = Integer.valueOf(s.charAt(s.length() - 1) + "");
            subVal += 2 * lastNum;
            return is7ber(s.substring(0, s.length() - 1), subVal);
        }
        return Integer.valueOf(s) % 7 == 0;
    }

}

