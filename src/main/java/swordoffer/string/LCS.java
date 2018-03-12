package swordoffer.string;

import org.junit.Test;

import java.util.*;

/**
 * Created by louzh on 2017/6/23.
 */
public class LCS {

    @Test
    public void run() {
//        String[] strs = {"1abc","2ab","3abcd"};
//        System.out.println(longestCommonPrefix(strs));
        int[] a = {1, 2};
        try {
            System.out.println(a[3]);
        } catch (Exception e) {

        }
        System.out.println("test");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int from = in.nextInt();
        int to = in.nextInt();
        int num = in.nextInt();
        Integer.toHexString(10);

    }

    public static String radixConvert(int num, int radix) {
        //递归结束条件
        if (num / radix == 0) {
            return "" + num;
        }
        //用于计数,即计算当前数的最高进制位个数
        int times = 0;
        //用于保存每次除的结果,且最后结果为最高位进制的计数
        int temp = num;
        while ((temp = (temp / radix)) >= radix) {
            times++;
        }
        //最高位后表示的数
        int timesNum = (int) (temp * Math.pow(radix, times + 1));
        return temp + "," + radixConvert(num - timesNum, radix);
    }

    public static int cmp(int g1, int g2, int[][] records, int n) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        //形成数据集
        for (int[] i : records) {
            if (map.get(i[0]) != null) {
                Set<Integer> set = map.get(i[0]);
                set.add(i[1]);
                map.put(i[0], set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(i[1]);
                map.put(i[0], set);
            }
        }
        List<Integer> list = new ArrayList();
        for (Integer key : map.keySet()) {
            if (map.get(key).contains(g2)) {
                if (key == g1) return 1;
                list.add(key);
            }
        }
        for (int i : list) {
            if (map.get(g1).contains(i))
                return 1;
        }

        list = new ArrayList();
        for (Integer key : map.keySet()) {
            if (map.get(key).contains(g1)) {
                if (key == g2) return -1;
                list.add(key);
            }
        }
        for (int i : list) {
            if (map.get(g2).contains(i))
                return -1;
        }
        return 0;
    }

    void temp() {
        Scanner in = new Scanner(System.in);
        String content = in.next();
        String resultOfInt = "";
        String resultOfUp = "";
        String resultOfLow = "";
        char[] chars = content.toCharArray();
        HashMap<Integer, Character> map = new HashMap<>();
        for (char c : chars) {
            map.put((int) c, c);
        }

        for (int i = 48; i <= 57; i++) {
            if (map.get(i) != null)
                resultOfInt += map.get(i);
        }
        for (int i = 65; i <= 90; i++) {
            if (map.get(i) != null)
                resultOfUp += map.get(i);
        }
        for (int i = 97; i <= 122; i++) {
            if (map.get(i) != null)
                resultOfLow += map.get(i);
        }

        System.out.println(resultOfLow + resultOfUp + resultOfInt);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int right_most = strs[0].length();
        for (int i = 1; i < strs[0].length(); i++) {
            for (int j = 0; j < right_most; j++) {
                if (j == strs[i].length() ||
                        strs[i].charAt(j) != strs[0].charAt(j))
                    right_most = j;
            }
        }
        return strs[0].substring(0, right_most);
    }
}
