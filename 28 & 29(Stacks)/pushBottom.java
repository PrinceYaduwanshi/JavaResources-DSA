import java.util.Stack;

public class pushBottom {
    public static void push_atBottom(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        push_atBottom(s, data);
        s.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        int data = 4;
        push_atBottom(s , data);

        while(!s.isEmpty()){
            System.out.println(s.pop()+" ");
        }
    }
}
