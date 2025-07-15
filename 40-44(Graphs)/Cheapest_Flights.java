import java.util.*;

public class Cheapest_Flights {

    static class Edge{
        int src;
        int dest;
        int cost;

        public Edge(int src, int dest, int cost){
            this.src= src;
            this.dest= dest;
            this.cost= cost;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++){
            int src= flights[i][0];
            int dest= flights[i][1];
            int wt= flights[i][2];

            Edge e= new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info{
        int vertex;
        int cost;
        int stops;

        public Info(int vertex, int cost, int stops){
            this.vertex= vertex;
            this.cost= cost;
            this.stops= stops;
        }


    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k){
        ArrayList<Edge> graph[]= new ArrayList[n];
        createGraph(flights, graph);

        int dist[]= new int[n];
        for(int i=0; i<n; i++){
            if(i != src){
                dist[i]= Integer.MAX_VALUE;
            }
        }

        Queue<Info> q= new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr= q.remove();
            if(curr.stops > k){
                break;
            }

            for(int i=0; i<graph[curr.vertex].size(); i++){
                Edge e= graph[curr.vertex].get(i);
                int u= e.src;
                int v= e.dest;
                int cost= e.cost;
                
                if(curr.cost + cost < dist[v] && curr.stops <= k){
                    dist[v]= curr.cost + cost; //jis raste ke through pauche uss raste ka cost dekhna hai naaki
                                              // uss vertex tk jaane me kitna cost lga wo,thus curr.cost instead of dist[u] 
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }

        //dist[dest]
        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dest];
        }

    }

    public static void main(String[] args) {
        int n= 4;
        int flights[][]= {
                        {0, 1, 100},
                        {1, 2, 100},
                        {1, 3, 600},
                        {2, 0, 100},
                        {2, 3, 600}};
        int src= 0; int dest= 3;
        int k=1;
        System.out.println(cheapestFlight(n, flights, src, dest, k));
        
    }
}
