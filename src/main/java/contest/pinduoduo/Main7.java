package contest.pinduoduo;


import java.math.BigDecimal;
import java.util.Scanner;

public class Main7 {

    public static void main(String[] args) {
        int[] minPosHeap = {0, 0, 0};
        int[] minNegHeap = {0, 0, 0};
        int[] maxNegHeap = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        boolean containZero = false;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 3) {
            return;
        }
        int val;
        for (int i = 0; i < n; i++) {
            val = sc.nextInt();
            if (val > 0) {
                insertToMinHeap(minPosHeap, val);
            } else if (val < 0) {
                insertToMinHeap(minNegHeap, -val);
                insertToMaxHeap(maxNegHeap, -val);
            } else {
                containZero = true;
            }
        }
        //没有正数
        if (minPosHeap[1] == 0 && minPosHeap[2] == 0) {
            if (containZero) System.out.println(0);
            else {
                BigDecimal d0 = BigDecimal.valueOf(-maxNegHeap[0]);
                BigDecimal d1 = BigDecimal.valueOf(maxNegHeap[1]);
                BigDecimal d2 = BigDecimal.valueOf(maxNegHeap[2]);
                System.out.println(d0.multiply(d1).multiply(d2));
            }
        }
        //没有负数
        else if (minNegHeap[1] == 0 && minNegHeap[2] == 0) {
            BigDecimal d0 = BigDecimal.valueOf(minPosHeap[0]);
            BigDecimal d1 = BigDecimal.valueOf(minPosHeap[1]);
            BigDecimal d2 = BigDecimal.valueOf(minPosHeap[2]);
            System.out.println(d0.multiply(d1).multiply(d2));
        } else {
            BigDecimal d0 = BigDecimal.valueOf(minPosHeap[0]);
            BigDecimal d1 = BigDecimal.valueOf(minPosHeap[1]);
            BigDecimal d2 = BigDecimal.valueOf(minPosHeap[2]);
            BigDecimal d3 = BigDecimal.valueOf(minNegHeap[1]);
            BigDecimal d4 = BigDecimal.valueOf(minNegHeap[2]);
            BigDecimal valD1 = d0.multiply(d1).multiply(d2);
            BigDecimal maxPos = d1.compareTo(d2) > 0 ? d1 : d2;
            BigDecimal valD2 = d3.multiply(d4).multiply(maxPos);
            System.out.println(valD1.compareTo(valD2) > 0 ? valD1 : valD2);
        }
    }

    public static void insertToMinHeap(int[] minHeap, int val) {
        if (minHeap[0] < val) {
            minHeap[0] = val;
            adjustHead(minHeap, true);
        }
    }

    public static void insertToMaxHeap(int[] maxHeap, int val) {
        if (maxHeap[0] > val) {
            maxHeap[0] = val;
            adjustHead(maxHeap, false);
        }
    }

    public static void adjustHead(int[] heap, boolean isMinHeap) {
        if (isMinHeap) {
            int minIdx = heap[1] > heap[2] ? 2 : 1;
            if (heap[0] > heap[minIdx]) {
                int temp = heap[0];
                heap[0] = heap[minIdx];
                heap[minIdx] = temp;
            }
        } else {
            int maxIdx = heap[1] > heap[2] ? 1 : 2;
            if (heap[0] < heap[maxIdx]) {
                int temp = heap[0];
                heap[0] = heap[maxIdx];
                heap[maxIdx] = temp;
            }
        }
    }
}