import java.util.*;
class Frog_k_jumps{

    public static int recurse(int height[], int n, int k){
        if( n == 0) return 0;

        int minJumps= Integer.MAX_VALUE;
        

        for(int j= 1; j<= k ; j++){
            if( (n - j) >= 0){
                int jumps= recurse(height, n-j, k) + Math.abs(height[n] - height[n-j]);
                minJumps= Math.min(minJumps, jumps);
            }
        }

        return minJumps;
    }

    public static int memo(int height[], int n, int k, int dp[]){
        if( n == 0) return 0;

        if(dp[n] != -1){
            return dp[n];
        }

        int minJumps= Integer.MAX_VALUE;

        for(int j= 1; j<= k ; j++){
            if( (n - j) >= 0){
                int jumps= memo(height, n-j, k, dp) + Math.abs(height[n] - height[n-j]);
                minJumps= Math.min(minJumps, jumps);
            }
        }

        return dp[n]= minJumps;
    }

    public static int tabulation(int height[], int n, int k){
        
        int dp[]= new int[n];
        dp[0]= 0;

        for(int i= 1; i<n; i++){
            int minJumps= Integer.MAX_VALUE;

            for(int j= 1; j<=k; j++){
                if( (i - j) >= 0){
                    int jump= dp[i - j] + Math.abs(height[i] - height[i-j]);
                    minJumps= Math.min(jump, minJumps);
                }
            }
            
            dp[i]= minJumps;
        }
        
        return dp[n-1];
    }

    public static void main(String[] args) {
        int height[]= {30, 10, 60, 10, 60, 50};
        int k= 2;
        int n= height.length;

        System.out.println("Recurssion: " + recurse(height, n-1, k));

        int dp[]= new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println("Memoization: " + memo(height, n-1, k, dp));

        System.out.println("Tabulation: "+ tabulation(height, n, k));


    }
}