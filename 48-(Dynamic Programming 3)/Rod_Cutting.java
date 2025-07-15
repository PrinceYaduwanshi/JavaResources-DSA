public class Rod_Cutting {

    public static int tabulation_Rod_Cutting(int length[], int prices[], int totalRod) {
        int n= length.length;
        int dp[][]= new int[n+1][totalRod+1];

        //initialization
        for(int i=0; i<n+1; i++){
            dp[i][0]= 0;
        }
        for(int j=0; j<totalRod+1; j++){
            dp[0][j]= 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<totalRod+1; j++){
                int piece_len= length[i-1];
                int piece_price= prices[i-1];

                //valid len
                if(piece_len <= j){
                    int include_price= piece_price +  dp[i][j - piece_len];
                    int exclude_price= dp[i-1][j];
                    dp[i][j]=  Math.max(include_price, exclude_price);
                }else{  //invalid length
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        print(dp);
        System.out.println();
        return dp[n][totalRod];

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
        int length[]= {1, 2, 3, 4, 5, 6, 7, 8};
        int prices[]= {1, 5, 8, 9, 10, 17, 17, 20};
        int totalLen= 8;
        System.out.println(tabulation_Rod_Cutting(length, prices, totalLen));
    }
}
