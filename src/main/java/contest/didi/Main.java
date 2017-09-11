package contest.didi;

import java.util.Scanner;

/**
 * Created by Lou on 2017/3/25.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String values = sc.nextLine();
        String[] valueString = values.split(" ");
        int[] val = new int[valueString.length];
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < valueString.length; i++) {
            val[i] = Integer.valueOf(valueString[i]);
            if (val[i] > maxVal) {
                maxVal = val[i];
            }
        }
        if (maxVal <= 0) {
            System.out.println(maxVal);
        } else {
            int maxSum = 0;
            for (int i = 0; i < val.length; i++) {
                for (int j = i; j < val.length; j++) {
                    int curSum = 0;
                    for (int k = i; k <= j; k++) {
                        curSum += val[k];
                    }
                    if (curSum > maxSum) {
                        maxSum = curSum;
                    }
                }
            }
            System.out.println(maxSum);
        }

    }

}
