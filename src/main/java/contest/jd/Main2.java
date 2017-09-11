package contest.jd;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                long val = (long) Math.pow(i, j);
                if (map.get(val) == null) {
                    map.put(val, 1l);
                } else {
                    map.put(val, map.get(val) + 1);
                }
            }
        }
        long count = 0;
        for (Long i : map.keySet()) {
            count += map.get(i) * map.get(i);
        }
        //处理结果为1的可能
        count = count + n * n;
        if (count >= 100000007) {
            count %= 100000007;
        }
        System.out.println(count);
    }
}