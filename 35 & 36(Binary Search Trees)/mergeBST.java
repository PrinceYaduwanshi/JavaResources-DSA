
import java.util.*;


public class mergeBST {
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


    public static void getInorder(Node root , ArrayList<Integer> arr){
        if( root == null ){
            return ;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node merge(Node root1 , Node root2){

        // get the inorder sequence
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root1 , arr1);
        getInorder(root2, arr2);

        // merging
        ArrayList<Integer> finalArr = new ArrayList<>();
        int i=0 , j=0;
        while( i < arr1.size() && j < arr2.size()){
            if( arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;    
            }
        }

        while( i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        // sorted array to balanced BSt
        return createBST(finalArr, 0, finalArr.size()-1);
    }

    public static Node createBST(ArrayList<Integer> arr , int stIdx , int endIdx){

        if( stIdx > endIdx){
            return null;
        }

        int mid = stIdx+ (endIdx - stIdx)/2;

        Node root = new Node(arr.get(mid));

        root.left = createBST(arr, stIdx, mid-1);
        root.right = createBST(arr, mid+1, endIdx);
        return root;
    }

    public static void main(String[] args) {
        
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = merge(root1, root2);
        levelorder(root);
        
    }
}
