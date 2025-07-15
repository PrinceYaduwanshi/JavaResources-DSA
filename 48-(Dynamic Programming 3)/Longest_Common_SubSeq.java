import java.util.*;

public class Longest_Common_SubSeq {

    
    public static int recurssive(String str1, String str2, int n, int m){
        if(n == 0 || m == 0) return 0;
        
        
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return recurssive(str1, str2, n-1, m-1) + 1;
        }else{
            int ans1= recurssive(str1, str2, n-1, m);
            int ans2= recurssive(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }

    }

    public static int memoization(String str1, String str2, int n, int m, int dp[][]){
        if(n == 0 || m == 0) return 0;

        if(dp[n][m] != -1){
            return dp[n][m];
        }
        
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m]= memoization(str1, str2, n-1, m-1, dp) + 1;
        }else{
            int ans1= memoization(str1, str2, n-1, m, dp);
            int ans2= memoization(str1, str2, n, m-1, dp);
            return dp[n][m]= Math.max(ans1, ans2);
        }

    }

    public static int tabulation(String str1, String str2, int n, int m){
        int dp[][]= new int[n+1][m+1];

        //initialization
        for(int i=0; i<n+1; i++){
            dp[i][0]= 0;
        }
        for(int j=0; j<m+1; j++){
            dp[0][j]= 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1] + 1;
                }else{
                    int ans1= dp[i-1][j];
                    int ans2= dp[i][j-1];
                    dp[i][j]= Math.max(ans1, ans2);
                }
            }
        }

        print(dp);
        return dp[n][m];
    }

    public static void print(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str1= "abcde";
        String str2= "ace";
        
        System.out.println(recurssive(str1, str2, str1.length(), str2.length()));

        int n= str1.length();
        int m= str2.length();

        // int dp[][]= new int[n+1][m+1];
        // for(int row[]: dp){
        //     Arrays.fill(row, -1);
        // }
        // System.out.println(memoization(str1, str2, n, m, dp));
        // print(dp);
        
        System.out.println(tabulation(str1, str2, n, m));
   
    }

}
