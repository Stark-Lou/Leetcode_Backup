package contest.BasicStructs;

/**
 * Created by Lou on 2017/3/12.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void add(ListNode node) {
        node.next = this.next;
        this.next = node;
    }

    public static void main(String[] args) {
        ListNode head, cur;
        head = new ListNode(0);
        cur = head;
        cur.next = new ListNode(1);
        cur = cur.next;
        cur.next = new ListNode(2);
        cur = cur.next;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
