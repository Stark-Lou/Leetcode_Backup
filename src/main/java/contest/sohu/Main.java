package contest.sohu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ages = new int[4];
        ages[0] = 1;
        while (n > 0) {
            n--;
            int cur = ages[3];
            ages[3] += ages[2];
            ages[2] = ages[1];
            ages[1] = ages[0];
            ages[0] = cur;
        }
        int count = 0;
        for (int i : ages) {
            System.out.println(i);
            count += i;
        }
        System.out.println(count);
    }


}
