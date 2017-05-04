package Contest.BasicStructs;

import java.util.ArrayList;

/**
 * Created by Lou on 2017/3/12.
 */
public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Integer integer = new Integer(1);
        ArrayList<Integer> list1 = new ArrayList();
        ArrayList<Integer> list2 = new ArrayList();
        while(l1!=null){
            list1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            list2.add(l2.val);
            l2 = l2.next;
        }
        int length = list1.size()<list2.size()?list2.size():list1.size();
        int sum = 0;
        boolean overTen = false;
        ArrayList<Integer> listSum = new ArrayList();
        for(int i=0;i<length;i++){
            if(list1.size()>i)
                sum += list1.get(i);
            if(list2.size()>i)
                sum += list2.get(i);
//            System.out.println(sum);
            if(sum>=10) {
                listSum.add(sum - 10);
                overTen = true;
            }
            else{
                listSum.add(sum);
                overTen = false;
            }
            //重置初始值
            if(overTen)
                sum = 1;
            else
                sum = 0;
        }
        if(sum==1)
            listSum.add(1);
        ListNode head = new ListNode(0);
        for(int i=listSum.size();i>0;){
            ListNode node = new ListNode(listSum.get(--i));
            //System.out.println(node.val);
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }
    public static ListNode insertToHead(ListNode node, ListNode head){
        node.next = head;
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        for(int i=0;i<10;i++){
            l2.add(new ListNode(9));
        }
        Solution.addTwoNumbers(l1,l2);

        String test = "AbCdE";
        char[] testChr = test.toCharArray();
        char headLetter = testChr[0];
        testChr[0] = 'a';
        for(char c:testChr){
            if(Character.isUpperCase(c))
                return;
            Character.isLetter(c);
        }
    }
}
