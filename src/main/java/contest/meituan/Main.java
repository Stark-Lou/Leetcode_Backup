package contest.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Lou on 2017/8/31.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] values = new int[N];
        int[] sums = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            values[i] = sc.nextInt();
            sum += values[i];
            sums[i] = sum;
        }
        int K = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            sums[i] = sums[i] % K;
            System.out.println(sums[i]);
            if (map.get(sums[i]) == null) {
                map.put(sums[i], i);
            } else if (map.get(sums[i]) > i) {
                map.put(sums[i], i);
            }
        }
        int maxSub = 0;
        for (int i = 0; i < N; i++) {
            int sub = i - map.get(sums[i]);
            if (sub > maxSub) {
                maxSub = sub;
            }
        }
        System.out.println(maxSub);
    }
}

