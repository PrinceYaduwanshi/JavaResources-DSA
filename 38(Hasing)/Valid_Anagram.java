
import java.util.HashMap;

public class Valid_Anagram {

    public static boolean isAnagram(String s, String t){
        HashMap<Character, Integer> map= new HashMap<>();
        int n1= s.length();
        int n2= t.length();
        for (int i = 0; i < n1; i++) {
            char ch= s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);   
        }

        for(int i=0; i<n2; i++){
            char ch= t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
            }else{
                return false;
            }
        }

        if(map.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args) {
        String s= "race";
        String t= "care";

        System.out.println(isAnagram(s, t));

    }
}
