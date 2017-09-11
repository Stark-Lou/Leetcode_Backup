package contest.Meitu;

import java.util.Scanner;

/**
 * @描述： ${DESCRIPTION}
 * @创建者： Louzhoucheng
 * @日期： 2017-04-16 19:17
 * @修改者： Louzhoucheng
 * @修改日期： 2017-04-16 19:17
 * @版本： v1.0
 */
public class LongestStr {

    static String quickSortInputOutput(String str) {
        String[] values = str.split(",");
        LinkList list = new LinkList();

        Node[] nodes = new Node[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Node();
            nodes[i].data = Integer.valueOf(values[i]);
            if (i > 0)
                nodes[i - 1].next = nodes[i];
        }
        list.head = nodes[0];
        quickSort(nodes[0], nodes[values.length - 1]);
        Node p = list.head;
        String result = "";
        while (p != null) {
            result += p.data + ",";
            p = p.next;
        }
        return result.substring(0, result.length() - 1);
    }

    static void quickSort(Node start, Node end) {
        if (start == null || end == null
                || start == end)
            return;
        Node first = start;
        Node second = start.next;
        int midValue = start.data;
        while (second != end.next && second != null) {
            if (second.data < midValue) {
                first = first.next;
                if (first != second) {
                    int temp = first.data;
                    first.data = second.data;
                    second.data = temp;
                }
            }
            second = second.next;
        }
        if (start != first) {
            int temp = start.data;
            start.data = first.data;
            first.data = temp;
        }
        quickSort(start, first);
        quickSort(first.next, end);
    }

    static void quickSort2(Node node) {
        if (node == null || node.next == null)
            return;
        int midValue = node.data;


    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }

        res = quickSortInputOutput(_str);
        System.out.println(res);
    }
}

class Node {
    public int data;
    public Node next;
}

class LinkList {
    public Node head;
}
