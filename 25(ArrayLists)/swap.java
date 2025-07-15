
import java.util.ArrayList;

public class swap {

    public static void swapNo( ArrayList<Integer> list , int idx1 , int idx2){
        int temp = list.get(idx2);
        list.set(idx2, list.get(idx1));
        list.set(idx1 , temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(9);
        list.add(8);
        list.add(12);

        int idx1 =2 , idx2=5;
        System.out.println(list);
        swapNo(list , idx1 , idx2);
        System.out.println(list);

    }
}
