import java.util.*;

public class Tree{

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

    static class BinaryTree{

        static int idx = -1;
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node new_node = new Node(nodes[idx]);
            new_node.left = buildTree(nodes);
            new_node.right = buildTree(nodes);

            return new_node;

        }

        public void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        public void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" "); 
            inorder(root.right);
        }

        public void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" "); 
            
        }

        public void levelorder(Node root){
            if(root == null){
                return;
            }
            
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            
            while( !q.isEmpty()){
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
                    if( currNode.right !=null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        public int height(Node root){
            if( root== null){
                return 0;
            }
            int left_height = height(root.left);
            int right_height = height(root.right);

            int maxHeight = Math.max(left_height, right_height)+1;
            return maxHeight;
        }

        public int count(Node root){
            if(root == null){
                return 0;
            }
            int left_count = count(root.left);
            int right_count = count(root.right);

            return left_count+right_count+1;
        }

        public int sum(Node root){
            if(root == null){
                return 0;
            }
            
            int left_sum = sum(root.left);
            int right_sum = sum(root.right);
            int tree_sum = left_sum + right_sum + root.data;
            return tree_sum;
        }

        public int diameter(Node root){
            if( root == null){
                return 0;
            }

            int left_diameter = diameter(root.left);
            int right_diameter = diameter(root.right);

            int left_height = height(root.left);
            int right_height = height(root.right);
            int selfDiameter = left_height + right_height + 1;

            return Math.max(selfDiameter, Math.max(left_diameter, right_diameter));
        }


        static class Info{
            int diameter;
            int height;

            public Info(int d , int h){
                this.diameter = d;
                this.height = h;
            }
        }
        public Info dia_meter(Node root){
            if(root == null){
                return new Info(0, 0);
            }

            Info leftInfo = dia_meter(root.left);
            Info rightInfo = dia_meter(root.right);

            int finalDiameter = Math.max( leftInfo.height+rightInfo.height+1 , Math.max(leftInfo.diameter, rightInfo.diameter) );
            int finalHeight = Math.max(leftInfo.height, rightInfo.height)+1;

            return new Info(finalDiameter, finalHeight);
        }


    }

    
    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node rootNode = tree.buildTree(nodes);

        System.out.println("Root Node is: "+rootNode.data);
        tree.preorder(rootNode);

        System.out.println();
        tree.inorder(rootNode);
        
        System.out.println();
        tree.postorder(rootNode);
        
        System.out.println();
        tree.levelorder(rootNode);
        
        System.out.println("Height of tree :"+tree.height(rootNode));

        System.out.println("No. of Nodes :"+tree.count(rootNode));

        System.out.println("Sum of Nodes :"+tree.sum(rootNode));

        System.out.println("Diameter of tree(Approcah 1) :"+tree.diameter(rootNode));

        System.out.println("Diameter of tree(Approcah 2) :"+tree.dia_meter(rootNode).diameter);
        System.out.println("Height of tree(Approcah 2) :"+tree.dia_meter(rootNode).height);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

    }
}