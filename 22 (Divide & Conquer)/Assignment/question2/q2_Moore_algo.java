
public class q2_Moore_algo {

    public static void majorityElement(int arr[] , int startIdx , int endIdx){
        int freq = 0 , ans =0 ;
        for(int i=startIdx ; i<arr.length ; i++){
            if(freq == 0){
                ans = arr[i];
            }
            if(ans == arr[i]){
                freq++;
            }else{
                freq--;
            }
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
        int arr[] = {2, 2, 2, 1, 1, 1, 2, 2, 2};
        majorityElement(arr, 0, arr.length-1);
    }
}
