package contest.sohu;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String path = sc.nextLine();
            System.out.println(simplifyPath(path));
        }
    }

    private static String simplifyPath(String path) {
        String[] pathArr = path.split("/");
        Stack<String> stringStack = new Stack<>();
        StringBuilder simplePath = new StringBuilder("");
        for (String s : pathArr) {
            if (s.equals("..") && !stringStack.isEmpty()) {
                stringStack.pop();
            } else if (s.equals("") || s.equals(".")) {
                continue;
            } else {
                stringStack.push(s);
            }
        }
        if (stringStack.isEmpty()) {
            return "/";
        }
        while (!stringStack.isEmpty()) {
            simplePath.insert(0, stringStack.pop());
            simplePath.insert(0, "/");
        }
        return simplePath.toString();
    }

}
