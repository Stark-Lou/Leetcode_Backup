package contest.zhuyan;


import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            int ni = sc.nextInt();
            arr[i] = new int[ni];
            for (int j = 0; j < ni; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int len = arr[i].length;
            int T = arr[i][len - 1] - arr[i][0];
            for (int j = 1; j <= T; j++) {
                if (isCycleT1(j, arr[i]) && isCycleT2(j, arr[i])) {
                    result[i] = j;
                    break;
                }
            }
        }
        for (int i : result) {
            System.out.println(i);
        }

    }

    private static boolean isCycleT1(int t, int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + t <= arr[arr.length - 1]) {
                if (Arrays.binarySearch(arr, arr[i] + t) < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isCycleT2(int t, int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] - t >= arr[0]) {
                if (Arrays.binarySearch(arr, arr[i] - t) < 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
