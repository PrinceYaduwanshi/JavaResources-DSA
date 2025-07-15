public class permutations {
    public static void findPermutation(String str , String ans){
        //BASE CASE 
        //original string is empty as all letters are selected
        if( str.length() == 0){
            System.out.println(ans);
            return;
        } 
        for(int i =0 ; i<str.length() ; i++){
            char currChar = str.charAt(i);
             //abcde -> c is picked ... "ab" + "de" = "ab+de"
             String newStr = str.substring(0, i) + str.substring(i+1);
             findPermutation(newStr, ans+currChar);
        }
    }
    public static void main(String[] args) {
        String str="abcde";
        findPermutation(str, "");
    }
}
