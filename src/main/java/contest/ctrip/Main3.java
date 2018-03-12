package contest.ctrip;

import java.util.Scanner;

public class Main3 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < b.length; i++) {
            b[i] = in.nextInt();
        }

        int[] c = new int[n + m];
        int i = 0;
        int ai = 0, bi = 0;
        while (i < (n + m) / 2 + 1) {
            if (bi >= m) {
                c[i] = a[ai];
                i++;
                ai++;
                continue;
            }
            if (ai >= n) {
                c[i] = b[bi];
                i++;
                bi++;
                continue;
            }
            if (a[ai] > b[bi]) {
                c[i] = b[bi];
                bi++;
                i++;
            } else {
                c[i] = a[ai];
                ai++;
                i++;
            }
        }
        int mid = (n + m) / 2;
        if ((n + m) % 2 == 0) {
            System.out.println((float) (c[mid] + c[mid - 1]) / 2);
        } else {
            System.out.println(c[mid]);
        }

    }
}
