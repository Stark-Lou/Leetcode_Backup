package contest.wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] music = new int[n];
        int[] musicCopy = new int[n];
        for (int i = 0; i < n; i++) {
            music[i] = sc.nextInt();
            musicCopy[i] = music[i];
        }
        Arrays.sort(music);
        int maxGap = 0;
        int maxGapIdx = 0;
        for (int i = 1; i < music.length; i++) {
            int gap = music[i] - music[i - 1];
            if (gap > maxGap) {
                maxGap = gap;
                maxGapIdx = i;
            }
        }
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        for (int i = 0; i < musicCopy.length; i++) {
            if (musicCopy[i] >= music[maxGapIdx]) {
                aList.add(musicCopy[i]);
            } else {
                bList.add(musicCopy[i]);
            }
        }
        int count = 0;
        for (int i = 1; i < aList.size(); i++) {
            count += Math.abs(aList.get(i) - aList.get(i - 1));
        }
        for (int i = 1; i < bList.size(); i++) {
            count += Math.abs(bList.get(i) - bList.get(i - 1));
        }
        System.out.println(count);

    }

}
