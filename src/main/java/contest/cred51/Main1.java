package contest.cred51;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main1 {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            list.add(sc.nextLine());
        }
        CallableU51 c1 = new CallableU51(0);
        CallableU51 c2 = new CallableU51(1);
        CallableU51 c3 = new CallableU51(2);
        FutureTask<Integer> f1 = new FutureTask<Integer>(c1);
        FutureTask<Integer> f2 = new FutureTask<Integer>(c2);
        FutureTask<Integer> f3 = new FutureTask<Integer>(c3);
        new Thread(f1).start();
        new Thread(f2).start();
        new Thread(f3).start();
        try {
            System.out.println(f1.get() + f2.get() + f3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static class CallableU51 implements Callable {

        int mod;
        int count;

        public CallableU51(int mod) {
            this.mod = mod;
        }

        @Override
        public Object call() throws Exception {
            for (int i = 0; i < list.size(); i++) {
                if (i % 3 == mod) {
                    if (list.get(i).contains("u51")) {
                        this.count++;
                    }
                }
            }
            return count;
        }
    }


}
