
public class mirrorBST {
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

    public static Node insert(Node root , int val){
        if( root == null){
            root = new Node(val);
            return root;
        }
    if(root.data > val){
        root.left = insert(root.left, val);
    }else{
        root.right = insert(root.right, val);
    }    
    return root;
    }

    public static void inorder(Node root){
        if( root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node mirror(Node root){
        if( root == null){
            return null;
        }

        Node leftMirror = mirror(root.left);
        Node rightMirror = mirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 6, 10, 11};
        Node root = null;

        for(int i =0 ; i<values.length ; i++){
            root = insert(root, values[i]);
        }

        root = mirror(root);
        inorder(root);

    }
}
