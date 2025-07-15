import java.util.Stack;

public class maxArea {

    public static void main(String args[]){
        int heights[] = {2, 1, 5, 6, 2, 3};
        int nextSmaller_Right[] = new int[heights.length];
        int nextSmaller_Left[] = new int[heights.length];

        // for next samller left  (i)
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i<heights.length ; i++){
            while( !s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if( s.isEmpty()){
                nextSmaller_Left[i] = -1;
            }else{
                nextSmaller_Left[i] = s.peek();
            }
            s.push(i);
        }

        
        // for next smaller right  (j)
        s = new Stack<>();
        for(int i= heights.length-1 ; i>=0 ; i--){
            while( !s.isEmpty() && heights[s.peek()] >=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextSmaller_Right[i] = heights.length;
            }else{
                nextSmaller_Right[i] = s.peek();
            }
            s.push(i);
        }

        // area calculation
        // width = j-i-1 = nsR[i] - nsL[i] -1
        int maxArea = 0;
        for(int i=0 ; i<heights.length ; i++){
            int height = heights[i];
            int width = nextSmaller_Right[i] - nextSmaller_Left[i] -1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        } 
        System.out.println("Maximum Area in Histogram is:" + maxArea);
    }
}
