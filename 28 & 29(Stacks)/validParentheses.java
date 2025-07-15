
import java.util.Stack;

public class validParentheses {

    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);
            if( ch == '(' || ch == '{' || ch == '[' ){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                boolean cond1 = s.peek() == '(' && ch == ')' ;
                boolean cond2 = s.peek() == '{' && ch == '}' ;
                boolean cond3 = s.peek() == '[' && ch == ']' ;
                if( cond1 || cond2 || cond3){
                    s.pop();
                }else{
                    return false;
                }
                
            }
        }
        return s.isEmpty();
        
    }

    public static void main(String[] args) {
        String str = "({}){]";
        System.out.println(isValid(str));
    }
}
