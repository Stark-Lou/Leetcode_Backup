package contest.fpjk;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n++;
        while (!isBeauty(n)) {
            n++;
        }
        System.out.println(n);
    }

    private static boolean isBeauty(int n) {
//        System.out.println(n);
        if (n < 0) {
            return false;
        } else {
            HashSet<Integer> set = new HashSet<>();
            while (n != 0) {
                if (set.contains(n % 10)) {
                    return false;
                } else {
                    set.add(n % 10);
                    n = n / 10;
                }
            }
            return true;
        }
    }

}
