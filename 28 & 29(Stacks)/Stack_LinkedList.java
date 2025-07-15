
public class Stack_LinkedList {

    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;

        }
    }
    static class Stack{
        static Node head = null;

        // isEmpty fnx
        public boolean isEmpty(){
            return head == null;
        }

        // pop fnx
        public void push(int data){
            Node new_Node = new Node(data);

            if(isEmpty()){
                head = new_Node;
                return;
            }

            new_Node.next = head;
            head = new_Node;
        }

        // pop fnx
        public int pop(){
            if(isEmpty()){
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }
        
        // peek fnx
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }

    }
}
