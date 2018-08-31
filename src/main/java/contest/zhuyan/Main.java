package contest.zhuyan;

import contest.youzan.Main2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int s = 0xfffffff;
        System.out.println(s == Integer.MIN_VALUE);
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        StringBuilder sb = new StringBuilder();
//        ArrayList<String> result =  generateParenthesis(n);
//        for (int i = 0; i < result.size(); i++) {
//            sb.append(result.get(i));
//            if(i != result.size() - 1){
//                sb.append(",");
//            }
//        }
//        System.out.println(sb.toString());
    }


    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0)
            return result;
        int left = 0, right = 0;
        String str = "";
        generateParenthesis(n, left, right, str, result);
        return result;
    }

    public static void generateParenthesis(int n, int left, int right, String str, ArrayList<String> result) {
        if (left > n || right > n || left < right)
            return;
        if (left == n) {
            StringBuilder strBuilder = new StringBuilder(str);
            for (int i = 0; i < n - right; i++)
                strBuilder.append(")");
            str = strBuilder.toString();
            result.add(str);
            return;
        }

        // left>=right
        generateParenthesis(n, left + 1, right, str + "(", result);
        generateParenthesis(n, left, right + 1, str + ")", result);

    }
}
