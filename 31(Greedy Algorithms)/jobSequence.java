
import java.util.*;

public class jobSequence {

    static class Job{
        int deadline;
        int profit;
        int id;//0(A) , 1(B) , 2(C) , 3(D) 
        public Job(int i , int d , int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][] = {
            {4, 20},
            {1, 10},
            {1, 40},
            {1, 30}
        };

        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0 ; i<jobInfo.length ; i++){
            jobs.add(new Job(i, jobInfo[i][0] , jobInfo[i][1]));
        }

        // Collections.sort(jobs , (a,b) -> a.profit-b.profit); //ascending order profit

        Collections.sort(jobs , (obj1 , obj2) -> obj2.profit-obj1.profit); //descending order profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i=0 ; i<jobs.size() ; i++){
            Job currJob = jobs.get(i);
            if( currJob.deadline > time){
                seq.add(currJob.id);
                time++;
            }
        }
        System.out.println("Maximum Job that can be done is: "+seq.size());
        for(int i=0 ; i<seq.size() ; i++){
            System.out.print(seq.get(i)+",");
        }
        System.out.println();

    }
}
