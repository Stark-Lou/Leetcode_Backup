package contest.TouTiao;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Lou on 2017/3/23.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> set = new HashSet();
        while (in.hasNext()) {
            String uid = in.next();
            if ("0".equals(uid))
                break;
            set.add(uid);
        }
        System.out.println(set.size());
    }
}

