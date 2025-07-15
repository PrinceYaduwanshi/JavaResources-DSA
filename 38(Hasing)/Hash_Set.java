
import java.util.HashSet;

public class Hash_Set {
    public static void main(String[] args) {
        HashSet<Integer> set= new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(2);

        System.out.println(set);
        System.out.println(set.size());
        // set.remove(2);
        if(set.contains(2)){
            System.out.println("contains 2");
        }

        if(set.contains(5)){
            System.out.println("contains 2");
        }else{
            System.out.println("not conatins 5");
        }

        set.clear();
        System.out.println(set.size());

    }
}
