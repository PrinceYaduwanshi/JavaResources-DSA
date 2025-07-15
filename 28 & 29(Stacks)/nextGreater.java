
import java.util.Stack;

public class nextGreater {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        int arr[] = {6, 8, 0, 1, 3};
        int nextGtr[] = new int[arr.length];
        for( int i=arr.length-1 ; i>=0 ; i--){
            while( !s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if( s.isEmpty()){
                nextGtr[i] = -1;
            }else{
                nextGtr[i] = arr[s.peek()]; 
            }
            s.push(i);
        }

        for(int i=0 ; i<nextGtr.length ; i++){
            System.out.print(nextGtr[i]+" ");
        }
        System.out.println();

    }
}
