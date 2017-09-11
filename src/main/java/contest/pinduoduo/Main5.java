package contest.pinduoduo;


import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] sugars = new int[m];

        for (int i = 0; i < m; i++) {
            sugars[i] = sc.nextInt();
        }
        Arrays.sort(sugars);

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] battleAndHungry = new int[3];
            battleAndHungry[0] = sc.nextInt();
            battleAndHungry[1] = sc.nextInt();
            battleAndHungry[2] = i;             //idx
            list.add(battleAndHungry);
        }
        //按战斗力降序
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int[] bear : list) {
            for (int i = sugars.length - 1; i >= 0; i--) {
                if (sugars[i] <= bear[1]) {
                    bear[1] -= sugars[i];
                    sugars[i] = 0;
                }
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int[] bear : list) {
            System.out.println(bear[1]);
        }

    }
}