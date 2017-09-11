package contest.pinduoduo;


import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> h = new ArrayList(n);
        for (int i = 0; i < n; i++) {
            h.add(sc.nextInt());
        }
        int m = sc.nextInt();
        List<Integer> w = new ArrayList(m);
        for (int i = 0; i < m; i++) {
            w.add(sc.nextInt());
        }
        Collections.sort(h, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Collections.sort(w, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int hIdx = 0;
        int wIdx = 0;
        int count = 0;
        for (; hIdx < n; hIdx++) {
            if (w.get(wIdx) >= h.get(hIdx)) {
                count++;
                wIdx++;
            }
        }
        System.out.println(count);
    }
}
