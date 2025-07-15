import java.util.*;

public class Iterate_HashMap {
    public static void main(String[] args) {
       HashMap<String , Integer> hm = new HashMap<>();
       hm.put("India" , 100);
       hm.put("China" , 150); 
       hm.put("US" , 50);
       hm.put("Indonesia" , 6);
       hm.put("Nepal" , 5);

        // Iterate
        // Set<String> keys = hm.keySet();
        // System.out.println(keys);

        // for (String k : hm.keySet()) {
        //     System.out.println("key:"+ k +", value:"+hm.get(k));
        // }

        // for(Entry<String, Integer> val: hm.entrySet()){
        //     System.out.println(val);
        // }
        System.out.println(hm.entrySet());
    }
}
