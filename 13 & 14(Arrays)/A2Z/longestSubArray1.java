import java.util.HashMap;

public class longestSubArray1 {

    public static int longest_Subarray_sum_k(int arr[] , long k){
        int n = arr.length;
        HashMap<Long , Integer> map = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for(int i=0 ; i<n ; i++){
            sum += arr[i];

            if( sum == k){
                maxLen = i+1;
            }

            long rem = sum - k;

            // if sum - k exists already then calulate the length of current 
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // if does not contain the sum add it
            if(!map.containsKey(sum)){
                map.put(sum , i);
            }
        }
        return maxLen;
    }

    public static void main(String args[]){
        int[] a = {2, 0, 0, 3};
        long k = 3;
        int len = longest_Subarray_sum_k(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}
