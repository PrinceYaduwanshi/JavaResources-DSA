
public class min_DIstance {
    
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

        if( root == null){
            return null;
        }
        if(root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLCA = LCA(root.left , n1 , n2);
        Node rightLCA = LCA(root.right , n1, n2);

        if(rightLCA == null){
            return leftLCA;
        }
        if(leftLCA == null){
            return rightLCA;
        }

        return root;
    }
    
    public static int minDistance(Node root , int n1, int n2){
        Node lca = LCA(root, n1, n2);
        int dist1 = lcaDistance(lca , n1);
        int dist2 = lcaDistance(lca ,n2);

        return dist1 + dist2;
    }

    public static int lcaDistance(Node lca , int n){

        if( lca == null){
            return -1;
        }
        if( lca.data == n){
            return 0;
        }

        int leftDist = lcaDistance(lca.left, n);
        int rightDist = lcaDistance(lca.right, n);

        if(leftDist == -1 && rightDist ==-1){
            return -1;
        }else if(leftDist == -1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }

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

            System.out.println(minDistance(root, 4, 6));
        }
    
}
