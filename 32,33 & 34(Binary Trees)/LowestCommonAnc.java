
import java.util.ArrayList;


public class LowestCommonAnc {
    
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node LCA(Node root , int n1 , int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root , n1, path1);
        getPath(root , n2, path2);

        int i=0;
        for(; i<path1.size() && i<path2.size() ; i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        Node lca = path1.get(i-1);
        return lca; 
    }

    public static boolean getPath(Node root , int n , ArrayList<Node> path){

        if(root == null){
            return false;
        }

        path.add(root);

        if(root.data == n){
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if( foundLeft || foundRight){
            return true;
        }
        
        path.remove(path.size()-1);
        return false;

    }

    public static Node LCA2(Node root , int n1 , int n2){

        // BASE CASES
        if( root==null){
            return null;
        }
        if( root.data == n1 || root.data == n2 ){
            return root;
        }

        Node leftLCA = LCA2(root.left, n1, n2);
        Node rightLCA = LCA2(root.right, n1, n2);

        // valid value from left LCA and null from right
        // then ancestor lie in left LCA and vice versa

        if(rightLCA == null){
            return leftLCA;
        }
        if(leftLCA == null){
            return rightLCA;
        }

        // if both side return some valid value then root is the 1st LCA
        return root;
    }

    public static void main(String args[]){
        // Main Tree
        /*
                1
              /  \
            2     3
          /  \   / \
         4   5  6   7 

         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(LCA(root , 2, 5).data);
        System.out.println(LCA2(root , 4, 5).data);
    }
}
