package contest.other;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] edge = new int[M + 1][M + 1];
        int p, q, k;
        for (int i = 0; i < N; i++) {
            p = sc.nextInt();
            q = sc.nextInt();
            k = sc.nextInt();
            edge[p][q] = k;
        }
        boolean[] contains = new boolean[M + 1];
        contains[1] = true;
        for (int i = 1; ; ) {
            int minEdge = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = 1; j <= M; j++) {
                if (edge[i][j] != 0) {
                    if (edge[i][j] < minEdge) {
                        minEdge = edge[i][j];
                        minIdx = j;
                    }
                }
            }
            contains[minIdx] = true;
        }

    }

    public static int[] dijkstra(int[][] edge) {
        int M = edge.length + 1;
        int[] dis = new int[M];
        for (int i = 1; i <= M; i++) {
            for (int j = i + 1; j <= M; j++) {
                if (edge[i][j] != 0) {
                    if (dis[j] == 0 || dis[j] > dis[i] + edge[i][j])
                        dis[j] = dis[i] + edge[i][j];
                }
            }
        }
        return dis;
    }
}


