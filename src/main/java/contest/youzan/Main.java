package contest.youzan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            temp = new StringBuilder();
            while (i >= 0 && isChar(s.charAt(i))) {
                temp.append(s.charAt(i));
                i--;
            }
            if (temp.length() == 0)
                sb.append(s.charAt(i));
            else {
                i++;
                sb.append(reverseStr(temp.toString()));
            }
        }
        System.out.println(sb.toString());
    }

    private static String reverseStr(String temp) {
        StringBuilder sb = new StringBuilder();
        for (int i = temp.length() - 1; i >= 0; i--) {
            sb.append(temp.charAt(i));
        }
        return sb.toString();
    }

    private static boolean isChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
}
