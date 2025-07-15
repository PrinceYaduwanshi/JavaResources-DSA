
import java.util.ArrayList;


public class Array_Lists {
    public static void main(String[] args) {
        //     classname   objectName = new Classname()
        ArrayList<Integer> list = new ArrayList<>();

        // Add element //O(1)
        list.add(1);        
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1, 99);

        System.out.println(list);

        // Get Element O(1)
        int element = list.get(3);
        System.out.println(element);

        // Remove Element O(n)
        list.remove(2);
        System.out.println(list);

        // Set element at index O(n)
        list.set(2, 10);
        System.out.println(list);

        // Contains Element O(n)
        System.out.println(list.contains(22));
        System.out.println(list.contains(5));

        System.out.println(list.size());
    }
}   
