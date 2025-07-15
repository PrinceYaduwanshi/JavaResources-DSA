import java.util.*;
class PriorityQ{

    static class Student{
        String name;
        int rank;

        public Student(String name , int rank){
            this.name = name;
            this.rank = rank;
        }
    }

    public static void main(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(3); //O(log n)
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");
            pq.remove();
        }
    }
}