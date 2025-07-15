public class Count_BSTs {

    public static int countBST(int n){
        int dp[]= new int[n+1];

        dp[0]= dp[1]= 1;

        for(int i=2; i<n+1; i++){
            for(int j=0; j<=i-1; j++){
                int leftWays= dp[j];
                int rightWays= dp[i-j-1];
                dp[i] += leftWays * rightWays;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countBST(4));
    }
}
