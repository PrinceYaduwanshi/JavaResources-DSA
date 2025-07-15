import java.util.*;

public class MST_Prism{

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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
    
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
    
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
            
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
            
    }

    static class Pair implements Comparable<Pair>{
        int vertex;
        int cost;

        public Pair(int vertex, int cost){
            this.vertex= vertex;
            this.cost= cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }

    public static void Prims(ArrayList<Edge> graph[]){
        boolean visited[]= new boolean[graph.length];
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        int finalCost= 0;
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr= pq.remove();
            if(!visited[curr.vertex]){
                visited[curr.vertex]= true;
                finalCost += curr.cost;

                //get the neighbours
                for(int i=0; i<graph[curr.vertex].size(); i++){
                    Edge e= graph[curr.vertex].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("Final cost is: "+finalCost);
    }

    public static void main(String[] args) {
        int V=4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        Prims(graph);
    }
}
