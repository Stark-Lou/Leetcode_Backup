package swordoffer.string;

/**
 * Created by louzh on 2017/6/23.
 */

import java.util.Scanner;
import java.util.Stack;

public class Base {
    /**
     * 将数转为任意进制
     *
     * @param num
     * @param base
     * @return
     */
    public static String baseString(int num, int base) {

        StringBuffer str = new StringBuffer("");
        String digths = "0123456789";
        for (int i = 97; i <= 122; i++) {
            digths += (char) i;
        }
        for (int i = 65; i <= 90; i++) {
            digths += (char) i;
        }
        Stack<Character> s = new Stack<Character>();
        while (num != 0) {
            s.push(digths.charAt(num % base));
            num /= base;
        }
        while (!s.isEmpty()) {
            str.append(s.pop());
        }
        return str.toString();
    }

    public static String baseNum(String num, int from, int to) {
        if (from == to) {
            return num;
        }
        String digths = "0123456789";
        for (int i = 97; i <= 122; i++) {
            digths += (char) i;
        }
        for (int i = 65; i <= 90; i++) {
            digths += (char) i;
        }
        char[] chars = num.toCharArray();
        int len = chars.length;
        //先转化为十进制
        if (to != 10) {
            num = baseNum(num, from, 10);
        } else {
            int n = 0;
            for (int i = len - 1; i >= 0; i--) {
                n += digths.indexOf(chars[i]) * Math.pow(from, len - i - 1);
            }
            return n + "";
        }
        return baseString(Integer.valueOf(num), to);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String content = in.nextLine();
        String[] s = content.split(" ");
        int from = Integer.valueOf(s[0]);
        int to = Integer.valueOf(s[1]);
        String num = s[2];
        System.out.println(baseNum(num, from, to));
    }
}