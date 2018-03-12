package contest.fpjk;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] members = new int[n + 1];
        int[] groupTag = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int tag = sc.nextInt();
            while (members[tag] == 0 && groupTag[tag] != 0) {
                tag = groupTag[tag];
            }
            groupTag[i] = tag;
            members[tag]++;
            if (members[i] != 0 && i != tag) {
                members[tag] += members[i];
                members[i] = 0;
            }
        }
        int groupCount = 0;
        for (int i = 1; i < n + 1; i++) {
            if (members[i] != 0) {
                groupCount++;
            }
        }
        System.out.println(groupCount);
    }


}
