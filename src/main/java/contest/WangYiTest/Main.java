package contest.WangYiTest;

import java.util.ArrayList;

/**
 * Created by Lou on 2017/3/25.
 */
public class Main {

    public static void main(String[] args) {
        String s = "awangwawwcsa";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();
        char[] chars = s.toCharArray();

        String subStr = "";
        String longestSubStr = "";
        ArrayList<String> longestSubStrList = new ArrayList<>();
        for (char aChar : chars) {
            if (subStr.equals("")) {
                subStr = String.valueOf(aChar);
            } else {
                //出现重复字符，保留最长子串
                if (longestSubStr.length() < subStr.length()) {
                    longestSubStr = subStr;
                    longestSubStrList.clear();
                }
                if (subStr.indexOf(aChar) > -1) {

                    subStr = aChar + "";
                } else {
                    subStr += aChar;
                }
                longestSubStrList.add(subStr);
            }
        }
        for (String str : longestSubStrList) {
            System.out.println(str);
            int idx = s.indexOf(str);
            while (idx > 0 && str.indexOf(s.charAt(idx - 1)) < 0) {
                str = s.charAt(idx - 1) + str;
                idx--;
            }
            longestSubStr = longestSubStr.length() > str.length() ? longestSubStr : str;

        }
        return longestSubStr.length();
    }


}
