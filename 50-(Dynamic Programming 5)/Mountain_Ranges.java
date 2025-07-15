public class Mountain_Ranges {

    public static int moutain_n_valleys(int n){
        int dp[]= new int[n+1];

        dp[0]= dp[1]= 1;

        for(int i=2; i<n+1; i++){
            for(int j=0; j<=i-1; j++){
                int insidePairs= dp[j];
                int outsidePairs= dp[i-j-1];
                dp[i] += insidePairs * outsidePairs;
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(moutain_n_valleys(4));
    }
}
