
public class LL_Implement {
    static class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Queue{
        static Node head = null;
        static Node tail = null;

        public boolean isEmpty(){
            return head == null && tail == null;
        }
        
        public void enqueue(int data){
            Node new_node = new Node(data);
            if(head == null){
                head = tail = new_node;
                return;     
            }
            // rear updation
            tail.next = new_node;
            tail = new_node;  
        }

        public int dequeue(){
            if( isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int front = head.data;
            if( tail == head){
                tail = head = null;
            }else{
                head = head.next;
            }
            return front;
        }

        public int peek(){
            if( isEmpty() ){
                System.out.println("Queue is Empty");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        while( !q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.dequeue();
        }
        System.out.println();
    }

}
