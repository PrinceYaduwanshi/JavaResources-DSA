
import java.util.*;

public class indianCoins {
    public static void main(String[] args) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int value = 1029;

        Arrays.sort(coins , Comparator.reverseOrder());

        ArrayList<Integer> ans = new ArrayList<>();

        int count =0;
        for(int i=0 ; i<coins.length ; i++){
            if(value >= coins[i]){
                while( value >= coins[i]){
                    value -= coins[i];
                    count++;
                    ans.add(coins[i]);
                }
            }
        }
        System.out.println("No. of coins are: "+count);

        for(int i=0 ; i<ans.size() ; i++){
            System.out.print(ans.get(i)+" ");
        }
        System.err.println();
    }
}
