package swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by louzh on 2017/6/7.
 */
public class FindInArrays {
    static {
        System.out.println("static");
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        printListFromTailToHead(listNode1);
    }

    public static boolean Find(int target, int[][] array) {
        if (array == null) return false;
        int r = array.length;
        int c = array[0].length;
        if (r == 0 || c == 0) return false;
        int ri = 0;
        int ci = 0;
        while (true) {
            if (array[ri][ci] == target) return true;
            else if (array[ri][ci] < target) {
                ci = (ci + c) / 2;
            } else {
                ci = ci / 2;
            }
        }

    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) return null;
        ArrayList<Integer> list = new ArrayList<>();

        ListNode start = listNode;
        ListNode end = listNode.next;
        start.next = null;
        if (end == null) {
            list.add(start.val);
            return list;
        }
        ListNode temp = end.next;
        if (temp == null) {
            list.add(end.val);
            list.add(start.val);
            return list;
        }
        end.next = start;
        while (temp != null) {
            start = end;
            end = temp;
            temp = end.next;
            end.next = start;
        }
        while (end != null) {
            list.add(end.val);
            end = end.next;
        }
        return list;
    }

    private static void printListNode(ListNode end) {
        ListNode temp = end;
        while (temp != null) {
            System.out.println("val:" + temp.val);
            temp = temp.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
