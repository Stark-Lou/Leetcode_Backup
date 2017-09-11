package contest.tel;

import java.util.Scanner;

/**
 * Created by Lou on 2017/3/25.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String content = in.nextLine();
        char[] chars = content.toCharArray();
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == '.' || aChar == ',' || aChar == ' ') {
                if (count != 0) {
                    result.append(count).append(" ");
                    count = 0;
                }
            } else {
                count++;
            }
        }
        System.out.println(result.substring(0, result.length() - 1));

    }

}
