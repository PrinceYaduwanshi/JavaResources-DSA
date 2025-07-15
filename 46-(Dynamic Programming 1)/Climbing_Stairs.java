import java.util.*;

class Climbing_Stairs{

    public static int recurssive(int n){
        if(n == 0)return 1;
        if(n < 0) return 0;
        return recurssive(n-1) + recurssive(n-2);
    }

    public static int memoization(int n, int dp[]){
        if(n == 0)return 1;

        if(n < 0) return 0;

        if(dp[n] != -1) return dp[n];

        dp[n]= memoization(n-1, dp) + memoization(n-2, dp);

        return dp[n];
    }

    public static int tabulation(int n){
        int dp[]= new int[n+1];  //1. memory created
        
        dp[0]= 1;  //2. initialization with base case

        for(int i=1; i<=n; i++){  //3. fill the table
            if( i == 1){
                dp[i]= dp[i-1] + 0;
            }else{
                dp[i]= dp[i-1] + dp[i-2];
            }
        }

        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(recurssive(5));
        int n=5;
        int dp[]= new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(memoization(n, dp));

        System.out.println(tabulation(n));
    }
}