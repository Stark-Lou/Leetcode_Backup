package contest.pinduoduo;

import java.util.Scanner;

/**
 * 字典序
 */
public class Main_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine();
        int[] charsInNum = new int[26];
        char[] chars = content.toCharArray();
        boolean[] removeChar = new boolean[chars.length];
        char maxChar = 'a';
        for (char aChar : chars) {
            charsInNum[aChar - 97]++;
            if (aChar > maxChar) {
                maxChar = aChar;
            }
        }
        boolean head = true;
        for (int i = 0; i < chars.length - 1; i++) {
            //出现最大字符都予以保留
            if (chars[i] == maxChar) {
                head = false;
            }
            //在出现最大字符之前，所有重复字符都可以删除
            else if (charsInNum[chars[i] - 97] > 1 && head) {
                removeChar[i] = true;
                charsInNum[chars[i] - 97]--;
            }
            //重复字符，如果与后一个字符构成增序，可以删除
            else if (charsInNum[chars[i] - 97] > 1 && chars[i] < chars[i + 1]) {
                charsInNum[chars[i] - 97]--;
                removeChar[i] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < removeChar.length; i++) {
            if (!removeChar[i]) {
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());


    }
}
