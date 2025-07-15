
import java.util.*;

public class BSTtoBalanced {

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

    public static void getInorder(Node root , ArrayList<Integer> inorder){
        if( root == null){
            return;
        }
        getInorder(root.left , inorder);
        inorder.add(root.data);
        getInorder(root.right , inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder , int stIdx , int endIdx){
        if(stIdx > endIdx){
            return null;
        }
        int mid = (stIdx + endIdx)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, stIdx, mid-1);
        root.right = createBST(inorder, mid+1, endIdx);
        return root;
    }

    public static Node balanceBST(Node root){
        // get inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // sorted inorder -> balanced BST
        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }

    public static void levelorder(Node root){
        if( root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while ( !q.isEmpty()) {
            Node currNode = q.remove();
            if( currNode == null){
                System.out.println();
                if( q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if( currNode.left != null){
                    q.add(currNode.left);
                }
                if( currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        levelorder(root);
        
        root = balanceBST(root);
        System.out.println("---------");

        levelorder(root);

    }
}
