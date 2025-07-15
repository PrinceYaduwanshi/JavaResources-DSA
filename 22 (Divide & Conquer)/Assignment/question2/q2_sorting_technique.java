
import java.util.Arrays; 
public class q2_sorting_technique {
    
    public static void majorityELement(int arr[]){
        Arrays.sort(arr);
        int freq = 1 ; int ans = arr[0];
        for(int i=1 ; i<arr.length ; i++){
            if( arr[i] == arr[i-1]){
                freq++;
            }else{
                freq =1;
                ans = arr[i];
            }
        }
        System.out.println(ans);
    }

    public static void main(String args[]){
        int arr[] = {2, 2, 2, 1, 1, 1, 2, 2, 2};
        majorityELement(arr);
        
    }
}
