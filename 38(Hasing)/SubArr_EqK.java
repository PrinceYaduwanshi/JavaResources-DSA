
import java.util.HashMap;

public class SubArr_EqK{
    public static void main(String[] args) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int arr[]= {10, 2, -2, -20, 10};
        int k= -10;
        map.put(0,1);
        int sum=0,ans=0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            int rem= sum - k;

            if(map.containsKey(rem)){
                ans += map.get(rem);
            }

            map.put(sum, map.getOrDefault(rem, 0)+1);
        }
        System.out.println(ans);
    }
}
