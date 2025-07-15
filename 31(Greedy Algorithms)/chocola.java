import java.util.*;
public class chocola {
    public static void main(String[] args) {
        int n=4 , m=6;
        Integer vertical_cost[] = {2, 1, 3, 1, 4};
        Integer horizontal_cost[] = {4, 1, 2};

        Arrays.sort(vertical_cost , Collections.reverseOrder());
        Arrays.sort(horizontal_cost , Collections.reverseOrder());

        int hPtr = 0 , vPtr =0;
        int hPieces = 1 , vPieces = 1;
        int cost = 0;

        while (hPtr < horizontal_cost.length && vPtr < vertical_cost.length) {
            if(vertical_cost[vPtr] <= horizontal_cost[hPtr]){
                cost += horizontal_cost[hPtr] * vPieces;
                hPieces++;
                hPtr++;
            }else{
                cost += vertical_cost[vPtr] * hPieces;
                vPieces++;
                vPtr++;
            }
        }

        while( hPtr < horizontal_cost.length){
            cost += horizontal_cost[hPtr] * vPieces;
            hPieces++;
            hPtr ++;
        }

        while( vPtr < vertical_cost.length){
            cost += vertical_cost[vPtr] * hPieces;
            vPieces++;
            vPtr++;
        }

    System.out.println("Total Minmum costs is: "+cost);
    System.out.println(hPieces*vPieces);
        
    }
}
