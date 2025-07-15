
import java.util.ArrayList;

public class pairSum2 {

    public static boolean pairSum2_twoPointer(ArrayList<Integer> list , int target){
        int breaking_Point = -1;
        for(int i=0 ; i<list.size() ; i++){
            if(list.get(i) > list.get(i+1)){
                breaking_Point = i;
                break;
            }
        }
        int leftPtr = breaking_Point+1;
        int rightPtr = breaking_Point;
        while(leftPtr != rightPtr){
            if(list.get(leftPtr) + list.get(rightPtr) == target){
                return true;
            }
            if(list.get(leftPtr) + list.get(rightPtr) < target){
                leftPtr = (leftPtr+1) % list.size(); 
            }
            if(list.get(leftPtr) + list.get(rightPtr) > target){
                rightPtr = (list.size() + rightPtr -1) % list.size();
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 27;
        System.out.println(pairSum2_twoPointer(list, target));
    }
}
