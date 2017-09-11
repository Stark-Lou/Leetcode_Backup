package swordoffer.string;

import java.util.Scanner;

public class CharTypeCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String content = in.nextLine();
        System.out.println(reverseWords(content));
    }

    public static String reverseWords(String str) {
        if (str.trim().equals("")) {
            return str;
        }
        String[] a = str.split(" ");
        StringBuffer o = new StringBuffer();
        int i;
        for (i = a.length; i > 0; i--) {
            o.append(a[i - 1]);
            if (i > 1) {
                o.append(" ");
            }
        }
        return o.toString();
    }
}
