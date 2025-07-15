import java.util.*;

public class Linked_HashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs= new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mimbai");
        lhs.add("Pak");
        lhs.add("odi");
        lhs.add("Mimbai");

        Iterator it= lhs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println();
        for(String city: lhs){
            System.out.println(city);
        }
    }
}
