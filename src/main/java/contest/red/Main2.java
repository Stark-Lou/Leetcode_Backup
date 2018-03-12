package contest.red;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbs = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            numbs[i] = sc.nextInt();
            if (numbs[i] == 1) {
                count++;
            } else {
                count--;
            }

        }
        if (count == 0) {
            System.out.println(n);
        }
    }
}