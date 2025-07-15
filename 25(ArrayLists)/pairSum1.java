import java.util.ArrayList;

public class pairSum1 {

    public static boolean pairSum_BruteForce(ArrayList<Integer> list , int target){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
            if(list.get(i)+list.get(j) ==  target){
                return true;
            }        
            }    
        }
        return false;
    }

    public static boolean pairSum_twoPointer(ArrayList<Integer> list1 , int target){
        int leftPtr = 0;
        int rightPtr = list1.size()-1;
        while(leftPtr != rightPtr) {
           if(list1.get(leftPtr)+list1.get(rightPtr) == target){
                return true;
           }

        //    moving left pointer increase sum 
           if(list1.get(leftPtr)+list1.get(rightPtr) < target){
                leftPtr++;
           }
           //    moving right pointer decrease sum 
           if(list1.get(leftPtr)+list1.get(rightPtr) > target){
                rightPtr--;
           }
            
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;
        // System.out.println(pairSum_BruteForce(list, target));
        System.out.println(pairSum_twoPointer(list, target));
        
    }
}
