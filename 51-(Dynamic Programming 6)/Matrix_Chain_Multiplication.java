import java.util.*;

public class Matrix_Chain_Multiplication{

    public static int recurssive_MCM(int arr[], int i, int j){
        if( i == j) return 0;  //single matrix case

        int ans= Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int cost1= recurssive_MCM(arr, i, k);
            int cost2= recurssive_MCM(arr, k+1, j);
            int cost3= arr[i-1] * arr[k] * arr[j];

            int finalCost= cost1 + cost2 + cost3;
            ans= Math.min(finalCost, ans);
        }

        return ans;
    }

    public static int memoization_MCM(int arr[], int i, int j, int dp[][]){
        if( i == j) return 0;  //single matrix case

        if(dp[i][j] != -1) return dp[i][j];

        int ans= Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            // Ai= arr[i-1] * arr[i]     (a x b)
            //Ak= arr[k-1] * arr[k]      (c x d)
            //Ai * Ak = arr[i-1] * arr[k];   (a x d  where b==c)
            int cost1= memoization_MCM(arr, i, k, dp);  

            //A(k+1)= arr[(k+1)-1] * arr[(k+1)]       (p x r)
            //Aj= arr[j-1] * arr[j]                   (m x n)
            //A(k+1) * Aj = arr[k] * arr[j];          (p x n where r==m)
            int cost2= memoization_MCM(arr, k+1, j, dp);

            //final cost of Ai * Aj
            //arr[i-1] * arr[k] * arr[j]
            //final cost will be ( a x d x n   where d==p here arr[k]) 
            int cost3= arr[i-1] * arr[k] * arr[j];

            int finalCost= cost1 + cost2 + cost3;
            ans= Math.min(finalCost, ans);

        }

        return dp[i][j]= ans;
    } 


    public static int tabulation_MCM(int arr[]){
        int n= arr.length;

        int dp[][]= new int[n][n];

        //initialization
        for(int i=0; i<n; i++){
            dp[i][i]= 0;
        }

        for(int len= 2; len<= n-1; len++){
            for(int i=1; i<=n-len; i++){
                int j= i + len -1;
                dp[i][j]= Integer.MAX_VALUE;
                for(int k=i; k<=j-1; k++){
                    int cost1= dp[i][k];
                    int cost2= dp[k+1][j];
                    int cost3= arr[i-1] * arr[k] * arr[j];
                    int finalCost= cost1 + cost2 + cost3;
                    dp[i][j]= Math.min(dp[i][j], finalCost);
                }
            }
        }

        print(dp);
        return dp[1][n-1];
    }

    public static void print(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] +"\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[]= {1, 2, 3, 4, 3};
        int n= arr.length;

        System.out.println(recurssive_MCM(arr, 1, n-1));

        int dp[][]= new int[n][n];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(memoization_MCM(arr, 1, n-1, dp));
        print(dp);

        tabulation_MCM(arr);
    }
}