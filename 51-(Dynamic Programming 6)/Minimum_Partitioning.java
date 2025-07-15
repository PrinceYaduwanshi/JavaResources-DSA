public class Minimum_Partitioning {

    public static int minSum(int arr[], int totalSum){
        int n= arr.length;
        int W= totalSum / 2;

        int dp[][]= new int[n+1][W + 1];

        for(int i=0; i<n+1; i++){
            dp[i][0]= 0;
        }
        for(int j=0; j<W+1; j++){
            dp[0][j]= 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                int val= arr[i-1];
                if(val <= j){
                    int include= val + dp[i-1][j-val];
                    int exclude= dp[i-1][j];
                    dp[i][j]= Math.max(include, exclude);
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        int sum1= dp[n][W];
        int sum2= totalSum - sum1;
        return Math.abs(sum2 - sum1);
    }


    public static void main(String[] args) {
        int arr[]= {1, 6, 11, 5};
        int totalSum= 0;
        for(int i=0; i<arr.length; i++){
            totalSum+= arr[i];
        }

        System.out.println(minSum(arr, totalSum));
    }
}
