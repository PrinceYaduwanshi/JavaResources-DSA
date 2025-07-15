
import java.util.ArrayList;

public class Stack_ArrayLists{
    
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();
        
        // isEmpty fnx
        public boolean isEmpty(){
            return list.size() == 0;
        }

        // push fnx
        public void push(int data){
            list.add(data);
        }

        // pop fnx
        public int pop(){
            if(isEmpty()){
                return -1;
            }

            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        // peek fnx
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }

        
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }

    }
}