
import java.util.PriorityQueue;

public class Sliding_Window {

    static class Pair implements Comparable<Pair>{
        int value;
        int idx;

        public Pair(int val , int i){
            this.value = val;
            this.idx = i;
        }

        @Override
        public int compareTo(Pair p2){
            /*for ascending::jiska value kam wo pehle yaani 1st priorty
            return this.value - p2.val */

            /* for descending :: jiska value jyada usko priorty pehla */
            return p2.value - this.value;
        }
    }


    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 6, 7};
        int k =3;
        int result_arr[] = new int[arr.length-k+1]; //n-k+1

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // 1st window 
        for(int i=0 ; i<k ; i++){
            pq.add(new Pair(arr[i], i));
        }

        result_arr[0] = pq.peek().value;
        
        for(int i=k ; i<arr.length ; i++){
            while( pq.size() > 0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            result_arr[i-k+1] = pq.peek().value;
        }

        // print arr
        for(int i=0 ; i< result_arr.length ; i++){
            System.out.print(result_arr[i]+" ");
        }
        System.out.println();
    }
}
