import java.util.*;

public class activitySelcn{
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        // end time basis sort
        int maxActivity = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // sorting
        int activities[][] = new int[start.length][3];
        for(int i=0 ; i<start.length ;i++){
            activities[i][0] = i; //index
            activities[i][1] = start[i]; //start time
            activities[i][2] = end[i]; //end time
        }
        // lambda fnx
        // sorting done on the basis of end time
        Arrays.sort(activities , Comparator.comparingDouble(o -> o[2]));

        // select 1st activity as it would be shortest
        maxActivity = 1;
        ans.add(activities[0][0]);
        // ans.add(0); 
        int lastEnd_time = activities[0][2];  //int lastEnd_time = end[0];

        for( int i=1 ; i<start.length ; i++){
            if(  activities[i][1] >= lastEnd_time  /*start[i] >= lastEnd_time*/){
                // select the activity
                maxActivity++;
                ans.add(activities[i][0]); // ans.add(i);
                lastEnd_time = activities[i][2];// lastEnd_time = end[i];
            }
        }

        System.out.println("Maximum Activity that can be selected is: "+ maxActivity);
        for(int i=0 ; i<ans.size() ; i++){
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
        
    }
}