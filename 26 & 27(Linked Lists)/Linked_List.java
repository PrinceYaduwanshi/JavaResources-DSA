


public class Linked_List{

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

    public int iterativeSearch(int key){
        Node temp = head;
        int i =0;
        while( temp != null){
            
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return Integer.MIN_VALUE;
    }

    public int helper(Node head , int key){
        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next , key);//recurse fnx
        //backtrack step
        if(idx == -1){
            return -1;
        }
        return idx+1;

    }
    public int recursiveSearch(int key){
        return helper(head , key);
    }

    public void reverseList(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while( curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;     
        }
        head = prev;
    }

    public void deleteNthNode(int n){
        int size = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        if( n == size){
            head = head.next;
            return;
        }
        int i=1;
        int idxSt = size -n;
        Node prev = head;

        while( i < idxSt){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;

    }

    public Node middleNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head == null || head.next==null){//only one node
            return true;
        }
        Node midNode = middleNode(head);

        // reversal step from half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node rightPtr = prev;
        Node leftPtr = head;
        while (rightPtr != null) {
            if(leftPtr.data != rightPtr.data){
                return false;
            }
            rightPtr = rightPtr.next;
            leftPtr = leftPtr.next;
        }
        return true;

    }

    public boolean isCycle(){
        
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;//cycle exists
            }
        }
        return false;//cycle does not exist
    }

    public void removeCycle(){
   
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
    
        if (!cycle) {
            return;
        }
    
        
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
    
       
        prev.next = null;
    }

    public static void main(String args[]){
        // Linked_List LL = new Linked_List();
        // LL.addFirst(1);
        // LL.addFirst(2);
        // LL.printList();
        // LL.addLast(6);
        // LL.addLast(7);
        // LL.printList();
        // LL.add(2, 9);
        // LL.printList();
        // System.out.println(size);
        // System.out.println();

        // Iterative Search
        // System.out.println(LL.iterativeSearch(9));

        // Recursive Search
        // System.out.println(LL.recursiveSearch(10));

        // REVERSAL 
        // LL.reverseList();
        // LL.printList();

        // Nth Delete Form end
        // LL.deleteNthNode(3);
        // LL.printList();

        // PALINDROME   
        // Linked_List LL2 = new Linked_List();
        // LL2.addLast(1);
        // LL2.addLast(2);
        // LL2.addLast(1);
        // // LL2.addLast(0);
        // LL2.printList();
        // System.out.println(LL2.checkPalindrome());


        // REMOVING ELEMENTS
        // System.out.println(LL.removeFirst());
        // LL.printList();
        // System.out.println(size);
        // System.out.println();

        // System.out.println(LL.removeLast());
        // System.out.println(LL.remove(0));
        // LL.printList();
        // System.out.println(size);

        // DETECT CYCLE
        Linked_List LL = new Linked_List();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next =  new Node(3);
        head.next.next = new Node(4);
        head.next.next.next =  head.next;//cyclic nodes
        System.out.println(LL.isCycle());
        System.out.println();
        LL.removeCycle();
        System.out.println(LL.isCycle());
        System.out.println();

    }
}