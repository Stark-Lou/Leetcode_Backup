package Contest.BasicStructs;

/**
 * Created by Lou on 2017/3/2.
 * 单链表
 */
public class LinkList {
    public Node head;

    /**
     * 插入新的节点到尾部
     * @param node 新插入的节点
     */
    public void addNode(Node node){
        //工作指针
        Node cur = head;
        //遍历到最后一个节点
        while(cur.next != null)
            cur = cur.next;
        //执行插入
        cur.next = node;
    }

    /**
     * 在指定的位置插入节点
     * @param idx 指定的节点位置
     * @param node 新插入的节点
     */
    public void insertNode(int idx, Node node){

        //工作指针
        Node cur = head;
        if(idx == 0){
            node.next = cur;
            this.head = node;
            return;
        }
        while (--idx >= 1){
            if(cur.next != null)
                cur = cur.next;
            else {
                System.out.println("插入错误！超过链表长度！");
                return;
            }
        }
        Node temp = cur.next;
        node.next = temp;
        cur.next = node;
    }

    public void printList(){
        Node cur = head;
        while(cur != null){
            System.out.println("Value:" + cur.value);
            cur = cur.next;
        }
    }

    public static void main(String[] args){
        LinkList list = new LinkList();
        list.head = new Node(1);
        list.addNode(new Node(2));
        list.addNode(new Node(3));
        list.addNode(new Node(4));
        list.insertNode(4,new Node(0));
        list.printList();
    }
}
