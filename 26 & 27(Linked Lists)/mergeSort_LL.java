
public class mergeSort_LL{

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

    // ADD ANY ELEMENT IN LINKED LIST
    public void add(int idx , int data){
        
        if(idx==0){
            addFirst(data);
            return;
        }

        Node new_node = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        new_node.next = temp.next;
        temp.next = new_node;
    }

    public int removeFirst(){
        if(size ==0 ){
            System.out.println("Linked List Empty");
            return Integer.MIN_VALUE;
        }else if( size == 1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if (size == 0){
            System.out.println("Linked list Empty");
            return Integer.MIN_VALUE;

        }else if(size == 1){
            int val = head.data;
            head = tail = head.next;
            size=0;
            return val;
        }
        Node prev = head;
        for(int i=0 ; i<size-2 ; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;    
    }

    // REMOVE ANY ELEMENT FROM LINKED LIST
    public int remove(int idx){
        if(idx ==0){
            int val = removeFirst();
            return val;
        }
        if (size == 0){
            System.out.println("Linked list Empty");
            return Integer.MIN_VALUE;

        }else if(size == 1){
            int val = head.data;
            head = tail = head.next;
            size=0;
            return val;
        }
        Node prev = head;
        Node temp = head.next;
        int i=0;
        while(i < idx-1){
            temp = temp.next;
            prev = prev.next;
            i++;
        }
        int val = temp.data;
        prev.next = temp.next;
        return val;
    }

    private Node getMiddleNode(Node head){
        Node slow = head;
        Node fast = head.next;
        while ( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    } 

    public Node mergeSort(Node head){
        // BASE CASE
        if(head == null || head.next == null){//single node
            return head;
        }
        // find middleNode
        Node midNode = getMiddleNode(head);

        // left and Right part sort
        Node rightNode = midNode.next;
        midNode.next = null;
        Node new_leftNode = mergeSort(head);
        Node new_RightNode =mergeSort(rightNode);
        
        // merge
        return mergeList(new_leftNode , new_RightNode);
    }

    private Node mergeList(Node leftNode , Node rightNode){
        Node merged_LL = new Node(-1);
        Node temp = merged_LL;
        while(leftNode != null && rightNode != null){
            if(leftNode.data <= rightNode.data){
                temp.next = leftNode; //temp->next pionts to samller node
                leftNode = leftNode.next;//leftNode or head 1 gets updtaed
                temp = temp.next;//temp moves to next node 
            }else{
                temp.next = rightNode;
                rightNode = rightNode.next;
                temp = temp.next;
            }
        }
        // for leftover elements

        while(leftNode != null){
            temp.next = leftNode;
            leftNode = leftNode.next;
            temp = temp.next;
        }
        while( rightNode != null){
            temp.next = rightNode;
            rightNode = rightNode.next;
            temp = temp.next;
        }
        return merged_LL.next;
    }

    public static void main(String[] args) {
        mergeSort_LL LL = new mergeSort_LL();
        LL.addLast(2);
        LL.addLast(5);
        LL.addLast(6);
        LL.addLast(4);
        LL.addLast(9);
        LL.printList();

        LL.head = LL.mergeSort(LL.head);
        LL.printList();
    }
}