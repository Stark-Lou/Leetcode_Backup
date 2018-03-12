package contest.youzan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int tX = 0, tY = 0;
        boolean tag = false;
        int[][] arr = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = x; i > 0 && !tag; i--) {
            for (int j = 0; j < y; j++) {
                if (arr[i][j] == val) {
                    tag = true;
                    System.out.println(i + " " + j);
                    break;
                } else if (arr[i][j] > val) {
                    break;
                }
            }
        }
        if (!tag) {
            System.out.println("-1 -1");
        }
    }

    public interface Int {

    }

}
