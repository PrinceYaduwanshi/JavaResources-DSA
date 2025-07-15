import java.util.*;
public class Kruskal_Algo {

    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src= src;
            this.dest= dest;
            this.wt= wt;
        }

        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }

    public static void createGraph(ArrayList<Edge> edges){

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 0, 10));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 0, 15));
        edges.add(new Edge(2, 3, 50));
    
    }

    static int n= 4;
    static int par[]= new int[4];
    static int rank[]= new int[4];

    public static void init(){
        for(int i=0; i<n; i++){
            par[i]= i;
        }
    }

    public static int find(int x){
        if(x == par[x]){
            return x;
        }
        // return find(x);
        return par[x]=find(par[x]);    //path compression
    }

    public static void union(int a, int b){
        int parA= find(a);
        int parB= find(b);

        if(rank[parA] == rank[parB]){
            par[parB]= parA;
            rank[parA]++;
        }else if(rank[parA] < rank[parB]){
            par[parA]= parB;
        }else{
            par[parB]= parA;
        }
    }


    public static void KruskalMST(ArrayList<Edge> edges, int V){
        init();
        Collections.sort(edges);

        int finalCost= 0;
        int count= 0; //to track no of edges added

        for(int i=0; count < V-1 ; i++){
            Edge e= edges.get(i);

            int parA= find(e.src); //src = A
            int parB= find(e.dest); //dest = B

            if( parA != parB){
                union(parA, parB);
                finalCost += e.wt;
                count++;
            }
        }

        System.out.println(finalCost);
    }

    public static void main(String[] args) {
        int V= 4;
        ArrayList<Edge> edges= new ArrayList<>();
        createGraph(edges);
        KruskalMST(edges, V);
    }
}
