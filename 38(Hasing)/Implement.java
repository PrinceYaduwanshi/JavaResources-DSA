import java.util.ArrayList;
import java.util.LinkedList;

public class Implement {

    static class HashMap<K,V>{ // generic ::: can be String , integer , boolean etc...
        private class Node{
            K key;
            V value;

            public Node(K key , V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; /*LL size*/
        private int N;//N : buckets.length
        private LinkedList<Node> bucket[]; 

        @SuppressWarnings("unchecked")
        public HashMap(){ /* default constructor */
            this.N = 4; //initial size = 4
            this.bucket = new LinkedList[4];
            for(int i =0 ; i<4 ; i++){
                this.bucket[i] = new LinkedList<>();
            }   
        }

        private int hashFunction(K key){
            int hash_code = key.hashCode();
            // can be any random value
            return Math.abs(hash_code) % N; /* modulo with size will give value b/w 0 to n-1  N : bucket size*/

        }

        private int search_in_LL(K key , int bi){
            LinkedList<Node> ll = bucket[bi]; //kis ll pr loop krna h
            int di=0;

            for( int i=0 ; i<ll.size() ; i++){
                Node node = ll.get(i); //linked list ka hrr node pr iterate krr rhe hn
                if(node.key == key){
                    return di; //agr node exist krta h toh uska index return krdo
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void reHash(){
            LinkedList<Node> oldBucket[] = bucket; //array of ll is stored
            bucket = new LinkedList[N*2]; //BUCKTES size doubled
            N = 2*N;
            for(int i=0 ; i<bucket.length ; i++){ //N doubled
                bucket[i] = new LinkedList<>(); //empty LL intialized
            }

            /* node -> add in bucket */
            for( int i=0 ; i< oldBucket.length ; i++){
              LinkedList<Node> ll = oldBucket[i];
              for(int j=0 ; j<ll.size() ; j++){
                Node node = ll.get(j);
                put(node.key, node.value);
              }  
            }

        }

        public void put(K key , V value){
            int bi = hashFunction(key);     // bucket index yaani kis jagah lagana h

            // value of index b/w 0 to n-1

            int di = search_in_LL(key , bi);   //LL pr kaha pr add krna h

            /*either di is valid or not */

            if(di !=-1){
                Node node = bucket[bi].get(di);
                node.value = value;
            }else{
                bucket[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n/N;
            if( lambda > 2.0){
                reHash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = search_in_LL(key, bi);

            if( di != -1){ //valid value exists
                return true;
            }else{
                return false;
            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = search_in_LL(key, bi);

            if( di != -1){
                Node node = bucket[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = search_in_LL(key, bi);

            if( di != -1){
                Node node = bucket[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for( int i=0 ; i<bucket.length ; i++){
                LinkedList<Node> ll = bucket[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }
        
    }

    public static void main(String[] args) {
        HashMap<String , Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US" , 50);
        hm.put("Nepal" , 5);

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println();
        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));

    }
}
