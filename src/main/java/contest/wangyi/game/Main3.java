package contest.wangyi.game;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        ArrayList<User> list = new ArrayList<>(n);
        String line = "";
        int command;
        long uid;
        int len;
        String nick = "";
        int noble;
        int guard;
        int role;
        int wealth;
        while (n > 0) {
            n--;
            line = sc.nextLine();
            int size = line.length();
            command = Integer.parseInt(line.substring(0, 4), 16);
            uid = Long.parseLong(line.substring(4, 12), 16);
            len = Integer.parseInt(line.substring(12, 15), 16);
            nick = line.substring(12, 12);
            noble = Integer.parseInt(line.substring(size - 16, size - 13), 16);
            guard = Integer.parseInt(line.substring(size - 12, size - 9), 16);
            role = Integer.parseInt(line.substring(size - 8, size - 5), 16);
            wealth = Integer.parseInt(line.substring(size - 4, size - 1), 16);
            User user = new User(uid, len, nick, noble, guard, role, wealth);
            list.add(user);
        }
        int m = sc.nextInt();//2 0001ff11ee550004616263640064000f01900009 00010000001200126a6c64616e736f7077666d6d7a736164756500ed004c02c00026
        Collections.sort(list);
        User target = list.get(m - 1);
        if (target != null) {
            System.out.println(target.uid);
        } else {
            System.out.println(-1);
        }
    }

    public static class User implements Comparable<User> {
        long uid;
        int len;
        String nick;
        int noble;
        int guard;
        int role;
        int wealth;

        public User(long uid, int len, String nick, int noble, int guard, int role, int wealth) {
            this.uid = uid;
            this.len = len;
            this.nick = nick;
            this.noble = noble;
            this.guard = guard;
            this.role = role;
            this.wealth = wealth;
        }

        @Override
        public int compareTo(User o) {
            if (this.noble != o.noble) {
                return o.noble - this.noble;
            }
            if (this.guard != o.guard) {
                return o.guard - this.guard;
            }
            if (this.role != o.role) {
                return o.role - this.role;
            }
            if (this.wealth != o.wealth) {
                return o.wealth - this.wealth;
            }
            return (int) (this.uid - o.uid);
        }
    }

}
