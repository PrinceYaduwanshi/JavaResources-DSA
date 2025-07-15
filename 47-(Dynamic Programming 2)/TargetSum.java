public class TargetSum {

    public static boolean tabulation_Sum(int nums[], int sum){
        int n= nums.length;
        boolean dp[][]= new boolean[n+1][sum+1];

        //i-items and 0 target sum
        for(int i=0; i<n+1; i++){
            dp[i][0]= true;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                
                int value= nums[i-1];
                
                //include
                if(value <= j && dp[i-1][j-value]){
                    dp[i][j]= true;
                }

                //exclude
                else if(dp[i-1][j]){
                    dp[i][j]= true;
                }
            }
        }

        print(dp);
        System.out.println();
        return dp[n][sum];
    }

    public static void print(boolean dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int nums[]= {4, 2, 7, 1, 3};
        int sum= 10;
        System.err.println(tabulation_Sum(nums, sum));
    }
}
