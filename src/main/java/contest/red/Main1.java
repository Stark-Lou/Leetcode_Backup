package contest.red;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine();
        content = content.replaceAll("RED", "");
        char[] chars = content.toCharArray();
        StringBuilder sb = new StringBuilder();
        char pre = 'a';
        for (char aChar : chars) {
            if (aChar > 58) {
                if (pre != ' ') {
                    sb.append(' ');
                    pre = ' ';
                }
            } else {
                pre = aChar;
                sb.append(aChar);
            }
        }
        String numArr = sb.toString();
        if (numArr.replaceAll(" ", "").equals("")) {
            System.out.println(-1);
        } else {
            String[] numbs = numArr.split(" ");

            int maxLen = 0;
            int maxLenIdx = 0;
            for (int i = 0; i < numbs.length; i++) {
                numbs[i] = numbs[i].replaceAll(" ", "");

                System.out.println(numbs[i]);
                if (numbs[i].length() > maxLen) {
                    maxLen = numbs[i].length();
                    maxLenIdx = i;
                } else if (numbs[i].length() == maxLen) {
                    for (int j = 0; j < maxLen; j++) {
                        if (numbs[i].charAt(j) > numbs[maxLenIdx].charAt(j)) {
                            maxLen = numbs[i].length();
                            maxLenIdx = i;
                        } else if (numbs[i].charAt(j) < numbs[maxLenIdx].charAt(j)) {
                            break;
                        }
                    }
                }
            }
            System.out.println(numbs[maxLenIdx]);
        }

    }
}