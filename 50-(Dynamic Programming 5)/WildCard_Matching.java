public class WildCard_Matching{

    public static boolean wildcard(String str, String pattern){
        int n= str.length();
        int m= pattern.length();

        boolean dp[][]= new boolean[n+1][m+1];

        //Initialization
        dp[0][0]= true;  //both txt and pattern are empty

        for(int i=1; i<n+1; i++){  //no pattern but txt exists
            dp[i][0]= false;
        }
        for(int j=1; j<m+1; j++){  //no txt but pattern exists
            if(pattern.charAt(j-1) == '*'){  //if the pattern is * then check if (j-1) pattern matches the txt or not
                dp[0][j]= dp[0][j-1];
            }else{
                dp[0][j]= false;
            }
        }

        //Filling the table

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){

                //case 1
                //ith char == jth char    OR    jth char is ?
                //then check if remain string is matching or nor
                if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?'){
                    dp[i][j]= dp[i-1][j-1];

                }

                //case 2
                // if pattern is * then 2 choices
                //either ignore or keep it for further
                else if(pattern.charAt(j-1) == '*'){
                    dp[i][j]= dp[i][j-1]  || dp[i-1][j];
                }


                //case 3
                //all the other cases rather than these are not considered thus false
                else{
                    dp[i][j]= false;
                }
            }
        }

        print(dp);
        return dp[n][m];
    }

    public static void print(boolean dp[][]) {
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str= "baaabab";
        // String pattern= "*****ba*****ab"; 
        String pattern= "a*ab";
        System.out.println(wildcard(str, pattern));
    }
} 