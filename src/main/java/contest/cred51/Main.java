package contest.cred51;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine();
        int[] lowCase = new int[26];
        int[] upCase = new int[26];
        char[] arr = content.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAlp = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (val >= 65 && val <= 90) {
                upCase[val - 65]++;
            } else if (val >= 97 && val <= 122) {
                lowCase[val - 97]++;
            } else {
                sb.append(arr[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < lowCase[i]; j++) {
                sbAlp.append((char) (i + 97));
            }
            for (int j = 0; j < upCase[i]; j++) {
                sbAlp.append((char) (i + 65));
            }
        }
        System.out.println(sbAlp.toString() + sb.toString());
    }


}
