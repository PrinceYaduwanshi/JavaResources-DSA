
import java.util.*;

public class queue_deq {

    static class Queue{
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data){
            deque.addFirst(data);
        }

        public int remove(){
            return deque.removeLast();
        }

        public int peek(){
            return deque.getLast();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.print(q.peek()+" ");
        q.remove();
        System.out.print(q.peek()+" ");
        q.remove();
        System.out.print(q.peek()+" ");
        q.remove();
        System.out.print(q.peek()+" ");
        q.remove();
        
    }
}
