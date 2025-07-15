import java.util.Stack;

public class reverseString {

    public static String reverse_string(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder();
        while ( !s.isEmpty()){
            char currChar = s.pop();
            result.append(currChar);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(reverse_string(str));

    }
}
