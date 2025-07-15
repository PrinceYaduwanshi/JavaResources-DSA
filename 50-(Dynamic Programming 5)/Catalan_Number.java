
import java.util.Arrays;

public class Catalan_Number {

    public static int recurssive_catalan(int n){
        if( n == 0 || n == 1) return 1;

        int ans= 0;
        for(int i=0; i<=n-1; i++){
            ans += recurssive_catalan(i) * recurssive_catalan(n-i-1);
        }
        return ans;
    }

    public static int memoization_catalan(int n, int dp[]){

        if( n == 0 || n == 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int ans= 0;
        for(int i=0; i<=n-1; i++){
            ans += memoization_catalan(i, dp) * memoization_catalan(n-i-1, dp);
        }

        dp[n]= ans;

        return dp[n];
    }

    public static int tabulation_catalan(int n){
        int dp[]= new int[n+1];

        dp[0]=dp[1]= 1;

        for(int i=2; i<n+1; i++){
            for(int j=0; j<=i-1; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        print(dp);
        return dp[n];
    }

    public static void print(int dp[]){
        for(int i=0; i<dp.length; i++){
            System.out.print(dp[i] +"  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(recurssive_catalan(4));

        int n= 4;
        int dp[]= new int[n+1];
        
        Arrays.fill(dp, -1);
        System.out.println("Memoization: "+ memoization_catalan(n, dp));
        
        System.out.println(tabulation_catalan(n));
    
    }
}
