package contest.ctrip;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int findMinMis(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] >= 0 && A[i] + 1 != A[i + 1]) {
                return A[i] + 1;
            }
        }
        return A[A.length - 1] + 1;

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _A_size = 0;
        _A_size = Integer.parseInt(in.nextLine().trim());
        int[] _A = new int[_A_size];
        for (int _A_i = 0; _A_i < _A_size; _A_i++) {
            _A[_A_i] = in.nextInt();
        }

        res = findMinMis(_A);
        System.out.println(String.valueOf(res));

    }
}
