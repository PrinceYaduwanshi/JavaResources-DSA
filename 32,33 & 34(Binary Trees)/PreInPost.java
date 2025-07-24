
import java.util.*;

public class PreInPost{

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data= data;
            this.left= this.right= null;
        }
    }

    static class Pair{
        Node node;
        int level;

        public Pair(Node node, int level){
            this.node= node;
            this.level= level;
        }
    }

    public static void allinOneTraversals(Node root){
        ArrayList<Integer> preOrder= new ArrayList<>();
        ArrayList<Integer> postOrder= new ArrayList<>();
        ArrayList<Integer> inOrder= new ArrayList<>();

        Stack<Pair> st= new Stack<>();
        st.push(new Pair(root, 1));
        
        while(!st.isEmpty()){
            //level 1: preOrder
            Pair p= st.peek();

            if(p.level == 1){
                //inc the level for inOrder
                st.peek().level++;

                //push data to list
                preOrder.add(p.node.data);

                //add the left to stack
                if(p.node.left != null){
                    st.push(new Pair(p.node.left, 1));
                }
            }

            //level 2: inOrder
            else if(p.level == 2){
                //inc the level for inOrder
                st.peek().level++;

                //push data to list
                inOrder.add(p.node.data);

                //add the left to stack
                if(p.node.right != null){
                    st.push(new Pair(p.node.right, 1));
                }
            }

            //level 3: postOrder
            else{
                postOrder.add(p.node.data);
                st.pop(); //no need the keep the val in stack now
            }
        }
        System.out.println("Pre Order is: "+preOrder);
        System.out.println("In Order is: "+inOrder);
        System.out.println("Post Order is: "+postOrder);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        allinOneTraversals(root);
    }
}