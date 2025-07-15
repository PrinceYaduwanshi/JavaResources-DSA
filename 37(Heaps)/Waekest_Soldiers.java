
import java.util.PriorityQueue;

public class Waekest_Soldiers {

    static class Soldier implements Comparable<Soldier>{
        int s_count;
        int idx;

        public Soldier(int s_count , int idx){
            this.s_count = s_count;
            this.idx = idx;
        }

        @Override
        public int compareTo(Soldier s2){
            if( this.s_count == s2.s_count){
                return this.idx - s2.idx;
            }else{
                return this.s_count - s2.s_count;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };

        int k=2;
        PriorityQueue<Soldier> pq = new PriorityQueue<>();
        for(int i=0 ; i<army.length ; i++){
            int count = 0;
            for(int j=0 ; j<army[0].length ; j++){
                count +=  army[i][j] == 1 ? 1:0;

            }
            pq.add(new Soldier(count, i));
        }

        for(int i=0 ; i<k ; i++){
            System.out.println("R"+pq.remove().idx);
        }
    }
}
