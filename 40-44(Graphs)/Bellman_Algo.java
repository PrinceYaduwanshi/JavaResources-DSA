import java.util.*;

public class Bellman_Algo {

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src= src;
            this.dest= dest;
            this.wt= wt;
        }

    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
    
        graph[1].add(new Edge(1, 2, -4));
    
        graph[2].add(new Edge(2, 3, 2));
            
        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

            
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src){
        int dist[]= new int[graph.length];

        for(int i=0; i<graph.length; i++){
            if( i != src){
                dist[i]= Integer.MAX_VALUE;
            }
        }

        int V= graph.length;
        // total tc: O(V*E)
        //algo
        //outer loop for V times -> O(V)
        for(int i=0; i<V-1; i++){
            //get the edges - O(E)
            for(int j=0; j<graph.length; j++){
                for(int k=0; k<graph[j].size(); k++){
                    Edge e= graph[j].get(k);

                    int u= e.src;
                    int v= e.dest;
                    int wt= e.wt;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v]= dist[u] + wt;
                    }
                }
            }
        }

        //print all distances
        for(int i=0; i<V; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }


    //only for edges
    public static void createGraph2(ArrayList<Edge> edges){

        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, -4));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(3, 4, 4));
        edges.add(new Edge(4, 1, -1));

            
    }

    public static void bellmanFord2(ArrayList<Edge> edges, int src, int V){
        int dist[]= new int[V];

        for(int i=0; i<dist.length; i++){
            if( i != src){
                dist[i]= Integer.MAX_VALUE;
            }
        }
        // total tc: O(V*E)
        //algo
        //outer loop for V times -> O(V)
        for(int i=0; i<V-1; i++){
            //get the edges - O(E)
            for(int j=0; j<edges.size(); j++){
                Edge e= edges.get(j);

                int u= e.src;
                int v= e.dest;
                int wt= e.wt;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v]= dist[u] + wt;
                }
            }
        }

        //print all distances
        for(int i=0; i<V; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V=5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        bellmanFord(graph, 0);

        ArrayList<Edge> edges= new ArrayList<>();
        createGraph2(edges);
        bellmanFord2(edges, 0, V);
    }
}
