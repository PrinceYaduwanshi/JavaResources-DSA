public class Longest_Word {
    static class Node{
        Node children[]= new Node[26]; //'a' to 'z'
        boolean eow= false;

        Node(){
            //constructor need not to be initialized as we use indices
            for(int i=0; i<26; i++){
                children[i]= null;
            }
        }
    }

    public static Node root= new Node(); // root of the trie

    public static void insert(String word){
        Node curr= root;
        for(int level=0; level<word.length(); level++){
            int idx= word.charAt(level)-'a';
            if(curr.children[idx] == null){
                curr.children[idx]= new Node();
            }
            curr= curr.children[idx];
        }
        curr.eow= true;
    }

    public static boolean search(String key){
        Node curr= root;
        for(int level=0; level<key.length(); level++){
            int idx= key.charAt(level)-'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr= curr.children[idx];
        }
        return curr.eow == true;
    }


    public static String ans="";
    public static void longestWord(Node root, StringBuilder temp){
        if(root == null){
            return;
        }

        for(int i=0; i<root.children.length; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char currCh = (char)(i+'a');
                temp.append(currCh);
                if(temp.length() > ans.length()){
                    ans= temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String words[]= {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
