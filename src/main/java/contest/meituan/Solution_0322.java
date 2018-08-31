package contest.meituan;

import java.util.HashMap;
import java.util.Scanner;

public class Solution_0322 {
    public static void main(String[] args) {
        testHashMap();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(minStr(sc.nextLine()));
        }
    }

    public static void testHashMap() {
        HashMap map = new HashMap();
        for (int i = 1; i < 17; i++) {
            map.put(i, i);
            System.out.println(map.size());
        }
    }

    public static int disSum(String s, String t) {
        int len = t.length();
        int sum = 0;
        for (int i = 0; i <= s.length() - len; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(j + i) != t.charAt(j)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static String minStr(String s) {
        int[] numInStr = new int[10];
        int val;
        int minVal = 11;
        for (int i = 0; i < s.length(); i++) {
            val = s.charAt(i) - 48;
            numInStr[val]++;
            if (val < minVal) {
                minVal = val;
            }
        }
        int minCount = numInStr[0];
        int minCountVal = 0;
        for (int i = 1; i < numInStr.length; i++) {
            if (numInStr[i] < minCount) {
                minCount = numInStr[i];
                minCountVal = i;
            }
        }
        if (minCount == 0) {        //存在未出现过的字符
            if (minCountVal == 0) {
                for (int i = 1; i < numInStr.length; i++) {
                    if (numInStr[i] == 0) {
                        return i + "";
                    }
                }
                return minVal + "0";
            } else {
                return minCountVal + "";
            }
        } else {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < minCount; i++) {
                sb.append(minCountVal);
            }
            if (minCountVal == 0) {
                return "10" + sb.toString();
            }
            sb.append(minCountVal);
            return sb.toString();
        }
    }
}
