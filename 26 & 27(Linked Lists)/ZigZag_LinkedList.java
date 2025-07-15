public class ZigZag_LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        // STEP 1(node shall always be created)
        Node new_node = new Node(data);
        size++;

        if(head == null){
            head = tail = new_node;
            return;
        }

        // STEP 2
        new_node.next = head; //linking

        // STEP 3
        head = new_node;
    }

    public void addLast(int data){
        Node new_Node = new Node(data);
        size++;

        if(head==null){
            head = tail = new_Node;
            return;
        }
        tail.next = new_Node;
        tail = new_Node;
    }

    public void printList(){
        if(head == null){
            System.out.println("Empty Linked List");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void zigZagLL(){
        // find middle Node
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next !=null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node midNode = slow;

        // reverse second half
        Node currNode = midNode.next; 
        midNode.next = null;
        Node prev = null;
        Node next;
        while( currNode!= null ){
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }

        // alternate merging or zig zag
        Node left_half_Node = head;
        Node right_half_Node = prev;
        Node nextLeft , nextRight;
        while( left_half_Node != null && right_half_Node !=null){

            nextLeft = left_half_Node.next;
            left_half_Node.next = right_half_Node;

            nextRight = right_half_Node.next;
            right_half_Node.next = nextLeft;

            // updation
            left_half_Node = nextLeft;
            right_half_Node = nextRight;

        } 

    }

    public static void main(String[] args) {
        ZigZag_LinkedList LL = new ZigZag_LinkedList();
        LL.addLast(2);
        LL.addLast(5);
        LL.addLast(6);
        LL.addLast(4);
        LL.addLast(9);
        LL.addLast(67);
        LL.printList();
        LL.zigZagLL();
        LL.printList();

    }
}
