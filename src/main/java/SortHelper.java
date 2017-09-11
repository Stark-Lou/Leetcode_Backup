import java.util.Arrays;

public class SortHelper {

    public static void main(String[] args) {
        int[] numbs = {8, 7, 6, 5, 4, 3, 2, 1};
//        bobbleSort(numbs);
        quickSort(numbs, 0, numbs.length - 1);
        System.out.println(Arrays.toString(numbs));
    }

    public static void bobbleSort(int[] numbs) {
        int temp;
        for (int i = numbs.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (numbs[j + 1] < numbs[j]) {
                    temp = numbs[j];
                    numbs[j] = numbs[j + 1];
                    numbs[j + 1] = temp;
                }
            }
            for (int num : numbs) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void quickSort(int a[], int start, int end) {
        if (start >= end) {
            return;
        }
        int key = a[end];
        int left = start;
        int right = end - 1;
        while (left < right) {
            while (a[left] <= key && left < right) {
                left++;
            }
            while (a[right] >= key && left < right) {
                right--;
            }
            swap(a, left, right);
        }
        System.out.println("left & end :" + left + " " + end);
        if (a[left] >= a[end]) {
            swap(a, left, end);
        } else {
            left++;
        }
        quickSort(a, start, left - 1);
        quickSort(a, left + 1, end);
    }

    private static void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        System.out.println(Arrays.toString(a));
    }

    public static void heapAdjust(int a[], int i, int nLength) {
        int nChild;
        int nTemp;
        for (nTemp = a[i]; 2 * i + 1 < nLength; i = nChild) {
            // 子结点的位置=2*（父结点位置）+ 1
            nChild = 2 * i + 1;
            // 得到子结点中较大的结点
            if (nChild < nLength - 1 && a[nChild + 1] > a[nChild])
                ++nChild;
            // 如果较大的子结点大于父结点那么把较大的子结点往上移动，替换它的父结点
            if (nTemp < a[nChild]) {
                a[i] = a[nChild];
                a[nChild] = nTemp;
            } else
                // 否则退出循环
                break;
        }
    }
}
