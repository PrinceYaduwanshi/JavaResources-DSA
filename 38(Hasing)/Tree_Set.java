import java.util.*;
public class Tree_Set {
    public static void main(String[] args) {
        TreeSet<String> set= new TreeSet<>();
        set.add("Delhi");
        set.add("Mimbai");
        set.add("Pak");
        set.add("odi");
        set.add("Mimbai");

        Iterator it= set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        for(String city: set){
            System.out.println(city);
        }
    }
}
