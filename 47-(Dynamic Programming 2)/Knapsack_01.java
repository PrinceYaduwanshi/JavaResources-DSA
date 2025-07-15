class Knapsack_01{

    public static int recurssive_Knapsack(int val[], int wt[], int W, int n){
        if( W == 0 || n == 0){
            return 0;
        }

        // (n-1) item no - 1 gives index of item
        if(wt[n-1] <= W){
            //include: add the val of item to ans 
            int ans1= val[n-1] + recurssive_Knapsack(val, wt, W-wt[n-1], n-1);
            
            //exclude: don't add the val of item
            int ans2= recurssive_Knapsack(val, wt, W, n-1);
            
            //ans must be the max which should be either including the item or excluding the item
            return Math.max(ans1, ans2);
        }else{
            return recurssive_Knapsack(val, wt, W, n-1);
        }
    }

    public static int memoization_Knapsack(int val[], int wt[], int W, int n, int dp[][]){
        if( W == 0 || n == 0){
            return 0;
        }

        if(dp[n][W] != -1){  //max profit is already calculated
            return dp[n][W];
        }

        // (n-1) item no - 1 gives index of item
        if(wt[n-1] <= W){
            //include: add the val of item to ans 
            int ans1= val[n-1] + memoization_Knapsack(val, wt, W-wt[n-1], n-1, dp);
            
            //exclude: don't add the val of item
            int ans2= memoization_Knapsack(val, wt, W, n-1, dp);
            
            //ans must be the max which should be either including the item or excluding the item
            dp[n][W]= Math.max(ans1, ans2);
            return dp[n][W];
        }else{
            dp[n][W]= memoization_Knapsack(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }


    public static int tabulation_Knapsack(int val[], int wt[], int W){
        int n= val.length;

        int dp[][]= new int[n+1][W+1];

        for(int i=0; i<dp.length; i++){  //initialize 0th col with 0 (wt =0)
            dp[i][0]= 0;
        }

        for(int j=0; j<dp[0].length; j++){  //initialize 0th row with 0 (item count =0)
            dp[0][j]= 0;
        }
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                int value= val[i-1];
                int weight= wt[i-1];  //wt of ith item if less then either include or exclude
                if(weight <= j){
                    int include_Profit= value + dp[i-1][j-weight];
                    int exclude_Profit= dp[i-1][j];
                    dp[i][j]= Math.max(include_Profit, exclude_Profit);
                }else{
                    int exclude_Profit= dp[i-1][j];
                    dp[i][j]= exclude_Profit;
                }
            }
        }

        print(dp);
        return dp[n][W];
    
    }

    public static void print(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }

            System.out.println();
        }
    }

    public static void main(String args[]){
        int val[]= {15, 14, 10, 45, 30};
        int wt[]= {2, 5, 1, 3, 4};
        int W= 7;
        System.out.println("Recurssive: "+recurssive_Knapsack(val, wt, W, val.length));


        int dp[][]= new int[val.length+1][W+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]= -1;
            }
        }

        System.out.println("Memoization: "+memoization_Knapsack(val, wt, W, val.length, dp));

        System.out.println("Tabulation: "+tabulation_Knapsack(val, wt, W));
    }
}