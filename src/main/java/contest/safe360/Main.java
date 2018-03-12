package contest.safe360;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] game = new int[n];
        for (int i = 0; i < n; i++) {
            game[i] = sc.nextInt();
        }
        Arrays.sort(game);
        int count = 0;
        for (int i = game.length - 1; i >= 0; i--) {
            if (t > game[i]) {
                t -= game[i];
                count++;
            }
        }
        System.out.println(count);
    }

}

