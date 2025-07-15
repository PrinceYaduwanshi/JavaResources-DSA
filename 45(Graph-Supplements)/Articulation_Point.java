import java.util.*;

public class Articulation_Point {

    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src= src;
            this.dest= dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    public static void getArticulationPoint(ArrayList<Edge> graph[], int V){
        int dt[]= new int[V]; //discovery time : for vertices
        int low[]= new int[V]; //lowest discovery time : for neighbours
        boolean visited[]= new boolean[V];
        boolean ap[]= new boolean[V];
        int time= 0;

        for(int i=0; i<V; i++){
            if(!visited[i]){
                DFS(graph, i, -1, dt, low, visited, time, ap);
            }
        }

        for(int i=0; i<V; i++){
            if(ap[i]){
                System.out.println("Ap: "+i);
            }
        }
    }


    public static void DFS(ArrayList<Edge> graph[], int curr, int parent, int dt[], int low[], boolean visited[], int time, boolean ap[]){
        visited[curr]= true;
        dt[curr]= low[curr]= ++time;
        int children= 0;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e= graph[curr].get(i);
            int neigh= e.dest;

            if(neigh == parent){
                continue;
            }else if(visited[neigh]){
                low[curr]= Math.min(low[curr], dt[neigh]);
            }else{
                DFS(graph, neigh, curr, dt, low, visited, time, ap);
                low[curr]= Math.min(low[curr], low[neigh]);
                if(parent != -1 && dt[curr] <= low[neigh]){
                    ap[curr]= true;
                }
                children++;
            }
        }

        if(parent == -1 && children > 1){
            ap[curr]= true;
        }

    }

    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        getArticulationPoint(graph, V);
    }
    
}
