package contest.chubao;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] val = new int[n];
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new Node(i));
        }
        for (int i = 1; i < n; i++) {
            int parent = sc.nextInt();
            map.get(parent).child.add(map.get(i));
        }
        for (int i = 0; i < n; i++) {
            map.get(i).val = sc.nextInt();
            val[i] = map.get(i).val;
        }
        Arrays.sort(val);
        int sum = 0;
        for (int i = 1; i < n; i++) {
            initMaxVal(map.get(i));
            initMaxValNoIn(map.get(i), val);
            sum += Math.abs(map.get(i).maxVal - map.get(i).maxValNoIn);
        }
        System.out.println(sum);
    }

    private static HashSet<Integer> initMaxValNoIn(Node node, int[] val) {
        HashSet<Integer> set = new HashSet<>();
        if (node.maxValNoIn != 0) {
            return set;
        }
        for (Node n : node.child) {
            set.addAll(initMaxValNoIn(n, val));
        }
        set.add(node.val);
        for (int i = val.length - 1; i >= 0; i--) {
            if (!set.contains(val[i])) {
                node.maxValNoIn = val[i];
                break;
            }
        }
        return set;
    }

    private static void initMaxVal(Node node) {
        if (node.maxVal != 0) {
            return;
        }
        for (Node n : node.child) {
            initMaxVal(n);
        }
        int maxVal = node.val;
        int val;
        for (Node n : node.child) {
            val = n.maxVal;
            if (val > maxVal) {
                maxVal = val;
            }
        }
        node.maxVal = maxVal;
    }

    public static class Node {
        int idx;
        int val;
        int maxVal;
        int maxValNoIn;
        List<Node> child = new ArrayList<>();

        public Node(int i) {
            idx = i;
        }
    }

}
