
import java.util.LinkedHashMap;

public class Linked_HM {
    public static void main(String[] args) {
        LinkedHashMap<String , Integer> hm = new LinkedHashMap<>();
        hm.put("india", 100);
        hm.put("china", 150);
        hm.put("nepal" , 50);
        hm.put("US" , 70);

        System.out.println(hm);
    }
}
