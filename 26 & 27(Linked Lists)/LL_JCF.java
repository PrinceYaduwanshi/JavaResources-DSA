import java.util.LinkedList;

public class LL_JCF {
    public static void main(String[] args) {
        // create 
        // class -->> object = new object;
        LinkedList<Integer> ll = new LinkedList<>();

        // add
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        System.out.println(ll);

        // remove
        ll.remove();
        System.out.println(ll);
        
    }
}
