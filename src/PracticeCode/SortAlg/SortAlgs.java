package PracticeCode.SortAlg;

/**
 * Created by Lou on 2017/4/11.
 */
public class SortAlgs {

    /**
     * 希尔排序
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void shellSort(T[] a){
        int j;
        for(int gap = a.length/2;gap>0;gap/=2){
            for(int i = gap; i<a.length;i++){
                T temp = a[i];
                for(j=i;j>gap && temp.compareTo(a[j-gap])<0;j-=gap)
                    a[j] = a[j-gap];
                a[j] = temp;
            }
        }
    }

    public static <T extends Comparable<? super T>>
        void mergeSort(T[] a,T[] tmpArray, int left, int right){
        if(left < right){
            int center = (left + right)/2;
            mergeSort(a,tmpArray,left,center);
            mergeSort(a,tmpArray,center+1,right);
            merge(a,tmpArray,left,center+1,right);
        }
    }

    private static <T extends Comparable<? super T>>
        void merge(T[] a, T[] tmpArray, int left, int middle, int right) {
        int mid = middle + 1; // 右边的起始位置
        int tmp = left;
        int third = left;
        while (left <= middle && mid <= right) {
            // 从两个数组中选取较小的数放入中间数组
            if (a[left].compareTo(a[mid])<=0) {
                tmpArray[third++] = a[left++];
            } else {
                tmpArray[third++] = a[mid++];
            }
        }
        // 将剩余的部分放入中间数组
        while (left <= middle) {
            tmpArray[third++] = a[left++];
        }
        while (mid <= right) {
            tmpArray[third++] = a[mid++];
        }
        // 将中间数组复制回原数组
        while (tmp <= right) {
            a[tmp] = tmpArray[tmp++];
        }
    }

}
