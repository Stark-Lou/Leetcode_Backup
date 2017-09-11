package contest.pinduoduo;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine();
        char[] chars = content.toCharArray();
        boolean checked = true;
        //记录栈内符号类型
        //1：{ 2：[ 3：（
        boolean hasType2 = false;
        boolean hasType3 = false;
        int[] stack = new int[chars.length];
        int stackIdx = -1;
        for (char aChar : chars) {
            //左符号入栈
            if (aChar == '{') {
                stackIdx++;
                stack[stackIdx] = 1;
            } else if (aChar == '[') {
                if (stackIdx >= 0 && stack[stackIdx] == 1) {
                    stackIdx++;
                    stack[stackIdx] = 2;
                } else {
                    checked = false;
                    break;
                }
            } else if (aChar == '(') {
                if (stackIdx >= 0 && stack[stackIdx] == 2) {
                    stackIdx++;
                    stack[stackIdx] = 3;
                } else {
                    checked = false;
                    break;
                }
            }
            //右符号消除，存在过上一级符号才能消除
            else if (aChar == '}') {
                if (stackIdx >= 0 && stack[stackIdx] == 1 && hasType2) {
                    stackIdx--;
                    hasType2 = false;
                } else {
                    checked = false;
                    break;
                }
            } else if (aChar == ']') {
                if (stackIdx >= 0 && stack[stackIdx] == 2 && hasType3) {
                    stackIdx--;
                    hasType3 = false;
                    hasType2 = true;
                } else {
                    checked = false;
                    break;
                }
            } else if (aChar == ')') {
                if (stackIdx >= 0 && stack[stackIdx] == 3) {
                    stackIdx--;
                    hasType3 = true;
                } else {
                    checked = false;
                    break;
                }
            }
        }
        if (checked) {
            System.out.println("表达式正确！");
        } else {
            System.out.println("错误的表达式");
        }

    }
}