
import java.util.*;

public class TopView {

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

        static class Info{
            Node node;
            int horizontal_distance;

            public Info(Node node , int h_Dist){
                this.node = node;
                this.horizontal_distance = h_Dist;
            }
        }

        public static void topView(Node root){
            // Level Order Traversal
            Queue<Info> q = new LinkedList<>();

            HashMap<Integer,Node> map = new HashMap<>();

            int min_Dist =0;
            int max_Dist = 0;

            q.add(new Info(root, 0));
            q.add(null);

            while( !q.isEmpty()){
                Info currInfo = q.remove();
                if( currInfo == null){
                    if( q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    //comaprisons
                    if( !map.containsKey(currInfo.horizontal_distance) ){ //first time occurence
                        map.put(currInfo.horizontal_distance, currInfo.node);
                    }

                    // left child
                    if( currInfo.node.left != null){
                        q.add(new Info(currInfo.node.left, currInfo.horizontal_distance-1));
                        min_Dist = Math.min(min_Dist, currInfo.horizontal_distance-1);
                    }
                    
                    // right child
                    if( currInfo.node.right != null){
                        q.add(new Info(currInfo.node.right, currInfo.horizontal_distance+1));
                        max_Dist = Math.max(max_Dist, currInfo.horizontal_distance+1);
                    }
                }    
            }
            
            for( int i=min_Dist ; i<=max_Dist ; i++){
                System.out.print(map.get(i).data+" ");
            }
            System.out.println();
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

        topView(root);

    }
}
