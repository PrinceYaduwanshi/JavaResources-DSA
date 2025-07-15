
import java.util.ArrayList;

public class mostWater {

    public static int mostWater_BruteForce(ArrayList<Integer> list1) {
        int maxWater = 0;
        int height,width,waterStored;

        for (int i = 0; i < list1.size(); i++) {
            for(int j=i+1 ; j<list1.size() ; j++){
                height = Math.min(j, i);
                width = j-1;
                waterStored = height*width;
                maxWater = Math.max(maxWater, waterStored);
            }    
        }
        return maxWater;
    }

    public static int mostWater_twoPointer(ArrayList<Integer> list1){
        int maxWater =0;
        int leftPtr = 0;
        int rightPtr = list1.size()-1;
        while(leftPtr < rightPtr){

            int height = Math.min(list1.get(rightPtr), list1.get(leftPtr));
            int width = rightPtr - leftPtr;
            int waterStored = height * width ;
            maxWater = Math.max(maxWater , waterStored);
            
            // jiksa height km hai usko update krna hai ya aaeg bdhana h
            if(list1.get(leftPtr) < list1.get(rightPtr)){
                leftPtr ++;
            }else{
                rightPtr--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(8);
        list1.add(6);
        list1.add(2);
        list1.add(5);
        list1.add(4);
        list1.add(8);
        list1.add(3);
        list1.add(7);
        // System.out.println(mostWater_BruteForce(list1));
        System.out.println(mostWater_twoPointer(list1));
    }
}
