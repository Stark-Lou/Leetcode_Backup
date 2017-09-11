package contest.TouTiao;

import java.util.Scanner;

/**
 * Created by Lou on 2017/3/23.
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String content = in.nextLine();
        String[] nmc = content.split(" ");
        int n = Integer.valueOf(nmc[0]);
        int m = Integer.valueOf(nmc[1]);
        int c = Integer.valueOf(nmc[2]);
        int[][] colorInLine = new int[c][n];
        int num, val;

        for (int i = 0; i < n; i++) {
            content = in.nextLine();
            String[] numbs = content.split(" ");
            num = Integer.valueOf(numbs[0]);
            for (int j = 1; j <= num; j++) {
                val = Integer.valueOf(numbs[j]);
                colorInLine[val - 1][i] = 1;
            }
        }

        int count = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < n; j++) {
                if (colorInLine[i][j] == 0) {
                    continue;
                }
                for (int k = j + 1; k < j + m; k++) {
                    int idx = k;
                    if (idx >= n) {
                        idx = k % n;
                    }
                    if (colorInLine[i][idx] == 1) {
                        count++;
                        System.out.println(i + " " + k);
                    }
                }
            }
        }
        System.out.println(count);
    }
}

