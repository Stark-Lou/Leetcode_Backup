package contest.wangyi2019;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Job[] jobs = new Job[N];
        for (int i = 0; i < N; i++) {
            jobs[i] = new Job(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(jobs);
        int[] A = new int[M];
        int[] result = new int[M];
        int key;
        int maxP = 0;
        for (int i = 0; i < M; i++) {
            A[i] = sc.nextInt();
            key = binarySearch(jobs, A[i]);
            for (int j = 0; j <= key; j++) {
                if (jobs[j].p > maxP) {
                    maxP = jobs[j].p;
                }
            }
            result[i] = maxP;
            maxP = 0;
        }
        for (int aResult : result) {
            System.out.println(aResult);
        }
    }

    public static int binarySearch(Job[] jobs, int d) {
        int right = jobs.length - 1;
        int left = 0;
        int mid;
        int compare;
        while (right > left) {
            if ((right - left) == 1 && jobs[left].d < d && jobs[right].d > d) {
                return left;
            }
            mid = (right + left) / 2;
            compare = jobs[mid].d - d;
            if (compare > 0) {
                right = mid - 1;
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    public static class Job implements Comparable<Job> {
        int d;
        int p;

        public Job(int d, int p) {
            this.d = d;
            this.p = p;
        }

        @Override
        public int compareTo(Job o) {
            return this.d - o.d;
        }
    }

}
