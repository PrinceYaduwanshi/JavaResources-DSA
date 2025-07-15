
public class createbalancedBST {
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

    public static void inorder(Node root){
        if( root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node createBST(int arr[] , int stIdx , int endIdx){
        if(stIdx > endIdx){
            return null;
        }
        int mid = (stIdx + endIdx)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, stIdx, mid-1);
        root.right = createBST(arr, mid+1, endIdx);
        return root;
    }

    public static void main(String[] args) {
        int values[] = {3, 5, 6, 8, 10, 11, 12};
        
        Node root = createBST(values, 0, 6);
        inorder(root);


    }
}
