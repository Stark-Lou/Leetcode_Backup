package contest.MicrosoftContest;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Lou on 2017/3/31.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float P = in.nextFloat() / 100;
        float Q = in.nextFloat() / 100;
        int N = in.nextInt();
        Node root = new Node(100);
        ArrayBlockingQueue<Node> q = new ArrayBlockingQueue<Node>(1000000);
        q.add(root);
        float result = 0;
        DecimalFormat formatter = new DecimalFormat("#.00");
        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n.item < N) {
                float pro = (float) (P / (Math.pow(2, n.item)));

                if (!n.rised) {
                    pro = n.pro + Q;
                }
                if (pro > 1)
                    pro = 1;
                n.addLeft(pro);
                q.add(n.left);
                if (1 - pro > 0) {
                    System.out.println(n.time);
                    n.addRight(1 - pro);
                    q.add(n.right);
                }
            } else {
                result += (n.value * n.time);
            }
        }

        System.out.println(formatter.format(result));
    }

    /**
     * bnary
     */
    public static class Node {
        int time;
        int item;
        float pro;
        float value;
        boolean rised;
        Node left;
        Node right;

        public Node(float pro) {
            time = 0;
            item = 0;
            value = 1;
            this.pro = pro;
            rised = true;
            left = null;
            right = null;
        }

        public void addLeft(float pro) {
            Node left = new Node(pro);
            left.time = time + 1;
            left.item = item + 1;
            left.value = this.value * pro;
            this.left = left;
        }

        public void addRight(float pro) {
            Node right = new Node(pro);
            right.time = time + 1;
            right.item = item;
            right.rised = false;
            right.value = this.value * pro;
            this.right = right;
        }
    }
}
