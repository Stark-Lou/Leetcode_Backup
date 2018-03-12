package contest.safe360;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] za = new int[n];
        for (int i = 0; i < za.length; i++) {
            za[i] = sc.nextInt();
        }
        int[] zaC = new int[n];
        for (int i = 0; i < zaC.length - 3; i++) {
            if (za[i] <= za[i + 1] && za[i + 1] <= za[i + 2]) {
                zaC[i] = 1;
            }
        }
        int m = sc.nextInt();
        int s, e;
        while (sc.hasNext()) {
            s = sc.nextInt();
            e = sc.nextInt();
            System.out.println(find(zaC, s, e));
        }
    }

    private static int find(int[] zaC, int s, int e) {
        if (e - s < 2) {
            return 0;
        }
        int count = 0;
        for (int i = s - 1; i < e - 2; i++) {
            count += zaC[i];
        }
        return count;
    }

}

