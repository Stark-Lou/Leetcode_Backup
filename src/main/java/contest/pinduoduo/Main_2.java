package contest.pinduoduo;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pi = new int[n];
        for (int i = 0; i < n; i++) {
            pi[i] = sc.nextInt();
        }
        int carCount = 0;
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        for (int i = 0; i < pi.length; i++) {
            if (pi[i] == 4) {
                count4++;
            } else if (pi[i] == 3) {
                count3++;
            } else if (pi[i] == 2) {
                count2++;
            } else {
                count1++;
            }
        }
        //4人队伍直接分配车辆
        carCount += count4;
        //双人队伍两两拼车
        carCount += count2 / 2;
        if (count2 % 2 != 0) {
            carCount++;
            count1 -= 2;
        }
        //三人队伍与单人拼车
        if (count1 > count3) {
            carCount += count3;
            count1 -= count3;
            carCount += count1 / 4;
            if (count1 % 4 != 0) {
                carCount++;
            }
        } else {
            carCount += count3;
        }
        System.out.println(carCount);
    }
}
