package contest.kuaishou;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        long n = sc.nextLong();
        long t = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                y -= 1;
                t = t * x % n;
            } else {
                y /= 2;
                x = x * x % n;
            }
        }
        System.out.println(t % n);
    }
}