import java.util.*;

// import javax.swing.text.html.HTMLDocument.Iterator;

public class Iterate_HashSet {
    public static void main(String[] args) {
        HashSet<String> set= new HashSet<>();

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
