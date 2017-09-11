package contest.BasicStructs;

/**
 * Created by Lou on 2017/3/2.
 * 单链表节点
 */
public class Node {
    public int value;
    public Node next;

    public Node() {
        this.value = 0;
        this.next = null;
    }

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Node(int val, Node next) {
        this.value = val;
        this.next = next;
    }
}
