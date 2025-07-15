public class Coin_Change{

    public static int tabulation_Coin_Change(int coins[], int sum){
        int n= coins.length;
        int dp[][]= new int[n+1][sum+1];

        //initialization

        //coins= 0 and sum >0 thus (0 way)
        for(int j=0; j<sum+1; j++){
            dp[0][j]= 0;
        }

        //sum= 0 and infinite coins thus (1 way)
        for(int i=0; i<n+1; i++){
            dp[i][0]= 1;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(coins[i-1] <= j){ //include
                    dp[i][j]= dp[i][j-coins[i-1]] + dp[i-1][j];
                }else{  //exclude
                    dp[i][j]= dp[i-1][j];
                }
            }
        }

        print(dp);
        System.out.println();
        return dp[n][sum];
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
        int coins[]= {2, 5, 3, 6};
        int sum= 10;
        System.out.println(tabulation_Coin_Change(coins, sum));
    }
}