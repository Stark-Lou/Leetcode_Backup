import contest.BasicStructs.Node;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2,new Node(3));
        ArrayList<Integer> list = new ArrayList();
        listToInt(node,list);
        int result = 0;
        for(Integer i:list){
            result = result * 10 + i;
        }
        System.out.println(result);
    }
    public static void listToInt(Node node,ArrayList<Integer> list){
        if(node.next == null)
            list.add(node.value);
        else {
            listToInt(node.next,list);
            list.add(node.value);
        }
    }

}
