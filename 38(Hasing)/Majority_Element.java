
import java.util.HashMap;

public class Majority_Element {
    public static void main(String[] args) {
        int arr[] = { 1,2};
        HashMap<Integer , Integer> hm = new HashMap<>();
        for(int i=0 ; i<arr.length ; i++){
            int num = arr[i];
            /* 
            if(hm.containsKey(num)){
                hm.put(num, hm.get(num)+1);
            }else{
                hm.put(num, 1);
            }
            */

            hm.put(num , hm.getOrDefault(num, 0)+1);
        }

        

        /* 
        Set<Integer> keySet = hm.keySet();
        for (Integer key : keySet) {
            if(hm.get(key) > arr.length/3){
                System.out.println(key);
            }
        }  
        */

        for(Integer key : hm.keySet()){
            if(hm.get(key) > arr.length/3){
                System.out.println(key);
            }
        }
    }
}
