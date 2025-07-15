
import java.util.Stack;

public class duplicateParentheses {

    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length() ; i++){
            char currChar = str.charAt(i);
 
            if( currChar == ')' ){
                int count=0;
                while( s.peek() != '(' ){
                    s.pop();
                    count++;
                }
                if(count < 1){
                    return true; //duplicate
                }else{
                    s.pop(); //pops opening pair
                }   
            }else{
                // opening , operator , operand
                s.push(currChar);
            }
            
        }
        return false;
        
    }

    public static void main(String[] args) {
        String str = "((a+b)+(c+d))";
        System.out.println(isValid(str));

    }
}
