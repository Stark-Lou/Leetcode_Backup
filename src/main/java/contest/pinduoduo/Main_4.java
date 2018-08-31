package contest.pinduoduo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 字典序
 */
public class Main_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int dis;
        int result;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                dis = Math.abs(i - j);
                if (dis > n / 2) {
                    dis = n - dis;
                }
                result = arr[i] + arr[j] + dis;
                if (map.get(result) == null) {
                    map.put(result, 1);
                } else {
                    map.put(result, map.get(result) + 1);
                }
            }
        }
        int max = 0;
        int maxCount = 0;
        for (Integer key : map.keySet()) {
            if (key > max) {
                max = key;
                maxCount = map.get(key);
            }
        }
        System.out.println(max + " " + maxCount);
    }
}
