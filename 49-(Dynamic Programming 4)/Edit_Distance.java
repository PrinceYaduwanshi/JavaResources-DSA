public class Edit_Distance {

    public static int edit_Dist(String str1, String str2){
        int n= str1.length();
        int m= str2.length();

        int dp[][]= new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if( i == 0) dp[i][j]= j; //2nd has ch and 1st is null
                if( j == 0) dp[i][j]= i; //1st has ch and 2nd is null
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1];
                }else{
                    int add= dp[i][j-1] + 1;
                    int delete= dp[i-1][j] + 1;
                    int replace= dp[i-1][j-1] + 1;   //for string conversion remove this

                    dp[i][j]= Math.min(add, Math.min(delete, replace));
                    // dp[i][j]= Math.min(add, delete);
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
        System.out.println(edit_Dist("abcdef", "aceg"));
    }
}
