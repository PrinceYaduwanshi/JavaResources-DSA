public class DoubleLinkedList {
    public class Node{

        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node new_node = new Node(data);
        size++;
        if(head == null){
            head = tail = new_node;
            return;
        }
        new_node.next = head;
        head.prev = new_node;
        head = new_node;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst(){
        if(head == null){
            System.out.println("Empty List");
            return -1;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;

    }

    public void reverse(){
        Node currNode = head;
        Node prev = null;
        Node next;
        while (currNode!=null) {
            next = currNode.next;

            currNode.next = prev;
            currNode.prev = next;

            prev = currNode;
            currNode = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoubleLinkedList dLL = new DoubleLinkedList();
        dLL.addFirst(1);
        dLL.addFirst(2);
        dLL.addFirst(3);
        dLL.printList();
        // dLL.removeFirst();
        dLL.reverse();
        dLL.printList();
    }
    
}
