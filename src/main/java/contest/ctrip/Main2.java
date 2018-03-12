package contest.ctrip;

import java.util.HashSet;
import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());

    }
}
