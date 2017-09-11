package contest.wangyi;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int n;
    public static int k;

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        for (String s : list) {
            if (s.equals("a")) {
                list.remove(s);
            }
        }

    }

    private static int countSize(int idx, int preValue) {
        int count = 0;
        if (idx == n - 1) return 1;
        for (int i = 1; i <= k; i++) {
            if (preValue <= i || preValue % i != 0) {
                count += countSize(idx + 1, i);
            }
        }
        return count;
    }
}
