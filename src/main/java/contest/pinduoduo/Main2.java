package contest.pinduoduo;


import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            String[] content = line.split(" ");
            String numStr1 = content[0];
            String numStr2 = content[1];
            int[] numb1 = new int[numStr1.length()];
            int[] numb2 = new int[numStr2.length()];
            int[] result = new int[numb1.length + numb2.length];
            for (int i = 0; i < numb1.length; i++) {
                numb1[i] = numStr1.charAt(numb1.length - i - 1) - '0';
            }
            for (int i = 0; i < numb2.length; i++) {
                numb2[i] = numStr2.charAt(numb2.length - i - 1) - '0';
            }
            for (int i = 0; i < numb1.length; i++) {
                for (int j = 0; j < numb2.length; j++) {
                    result[i + j] += numb1[i] * numb2[j];
                }
            }
            //移位、进位
            for (int i = 0; i < result.length - 1; i++) {
                result[i + 1] += result[i] / 10;
                result[i] = result[i] % 10;
            }
            System.out.println(Arrays.toString(result));
            StringBuilder sb = new StringBuilder();
            boolean start = true;
            for (int i = result.length - 1; i >= 0; i--) {
                if (result[i] == 0 && start) {
                } else {
                    start = false;
                    sb.append(result[i]);
                }
            }
            System.out.println(sb.toString());
        }

    }
}