
import java.util.Arrays;

public class minAbs {
    public static void main(String[] args) {
        int A[] = {1, 2, 3};
        int B[] = {2, 1, 3};
        Arrays.sort(A);
        Arrays.sort(B);

        int minAbs_Val = 0;
        for(int i=0 ; i<A.length ; i++){
            minAbs_Val += Math.abs(A[i] - B[i]);
        }

        System.out.println("Minimum Absolute Value is: "+minAbs_Val);
    }
}
