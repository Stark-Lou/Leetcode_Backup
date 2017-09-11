package contest.Alibaba;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Lou on 2017/3/25.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numGroup = sc.nextInt();
        int numMusic = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numGroup; i++) {
            list.add(sc.nextInt());
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        while (numMusic > numGroup) {
            numMusic--;
            int val = list.get(0) / 2;
            list.add(val);
            list.add(val);
            list.remove(0);
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
//            for(Integer i:list){
//                System.out.printf(i + " ");
//            }
//            System.out.println();
        }
        System.out.println(list.get(0));

    }

}
