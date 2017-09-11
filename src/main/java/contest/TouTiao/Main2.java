package contest.TouTiao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Lou on 2017/3/23.
 */
public class Main2 {
    private static final boolean T = true;
    private static final boolean F = false;

    private static final boolean[][] N1 = {{T}, {T}, {T}, {T}, {T}};
    private static final boolean[][] N2 = {{T, T, T},
            {F, F, T}, {T, T, T}, {T, F, F},
            {T, T, T}};
    private static final boolean[][] N3 = {{T, T, T},
            {F, F, T}, {T, T, T}, {F, F, T},
            {T, T, T}};
    private static final boolean[][] N4 = {{T, F, T},
            {T, F, T}, {T, T, T}, {F, F, T},
            {F, F, T}};
    private static final boolean[][] N5 = {{T, T, T},
            {T, F, F}, {T, T, T}, {F, F, T},
            {T, T, T}};
    private static final boolean[][] N6 = {{T, T, T},
            {T, F, F}, {T, T, T}, {T, F, T},
            {T, T, T}};
    private static final boolean[][] N7 = {{T, T, T},
            {F, F, T}, {F, F, T}, {F, F, T},
            {F, F, T}};
    private static final boolean[][] N8 = {{T, T, T},
            {T, F, T}, {T, T, T}, {T, F, T},
            {T, T, T}};
    private static final boolean[][] N9 = {{T, T, T},
            {T, F, T}, {T, T, T}, {F, F, T},
            {T, T, T}};
    private static final boolean[][] N0 = {{T, T, T},
            {T, F, T}, {T, F, T}, {T, F, T},
            {T, T, T}};
    private static final boolean[][] OP_DIV = {{F, F, F},
            {F, F, T}, {F, T, F}, {T, F, F},
            {F, F, F}};
    private static final boolean[][] OP_ADD = {{F, F, F},
            {F, T, F}, {T, T, T}, {F, T, F},
            {F, F, F}};
    private static final boolean[][] OP_MIN = {{F, F, F},
            {F, F, F}, {T, T, T}, {F, F, F},
            {F, F, F}};
    private static final boolean[][] OP_EQ = {{F, F, F, F},
            {T, T, T, T}, {F, F, F, F}, {T, T, T, T}, {F, F, F, F}};
    private static final boolean[][] OP_MULT = {{T, F, T},
            {F, T, F}, {T, F, T}, {F, F, F},
            {F, F, F}};
    private static final boolean[][] OP_POI = {{F, F},
            {F, F}, {F, F}, {T, T},
            {T, T}};


    public static void main(String[] args) {
//        printPicWords(N5);
//        System.out.println();
//        printPicWords(N6);
//        System.out.println();
//        printPicWords(N7);
        Scanner in = new Scanner(System.in);
        String cal = in.nextLine();
        String[] content = cal.split(" ");
        assert content.length == 3;
        int num1 = Integer.valueOf(content[0]);
        int num2 = Integer.valueOf(content[2]);
        int result = 0;
        String op = content[1];
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;  //todo 处理小数点问题
        }
        String s = content[0] + content[1] + content[2] + "=" + result;
        ArrayList list = format(s);
        printPicWords(list);
    }

    private static void printPicWords(ArrayList<boolean[][]> list) {
        //遍历打印6行内容
        for (int i = 0; i < 5; i++) {
            for (boolean[][] content : list) {
                for (int j = 0; j < content[0].length; j++) {
                    if (content[i][j])
                        System.out.print("*");
                    else System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static ArrayList format(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0)
            return null;
        ArrayList list = new ArrayList();
        for (char c : chars) {
            switch (c) {
                case '0':
                    list.add(N0);
                    break;
                case '1':
                    list.add(N1);
                    break;
                case '2':
                    list.add(N2);
                    break;
                case '3':
                    list.add(N3);
                    break;
                case '4':
                    list.add(N4);
                    break;
                case '5':
                    list.add(N5);
                    break;
                case '6':
                    list.add(N6);
                    break;
                case '7':
                    list.add(N7);
                    break;
                case '8':
                    list.add(N8);
                    break;
                case '9':
                    list.add(N9);
                    break;
                case '+':
                    list.add(OP_ADD);
                    break;
                case '-':
                    list.add(OP_MIN);
                    break;
                case '*':
                    list.add(OP_MULT);
                    break;
                case '/':
                    list.add(OP_DIV);
                    break;
                case '=':
                    list.add(OP_EQ);
                    break;
            }
        }
        return list;
    }
}

