import java.util.*;

public class All_Paths {

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

        graph[0].add(new Edge(0, 3));
    
        graph[2].add(new Edge(2, 3));
    
        graph[3].add(new Edge(3, 1));
            
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
    
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
            
    }

    public static void getPaths_DFS(ArrayList<Edge> graph[], int src, int dest, ArrayList<Integer> path){
        if(src == dest){
            path.add(dest);
            System.out.println(path);
            return;
        }

        path.add(src);
        for(int i=0; i<graph[src].size(); i++){
            Edge e= graph[src].get(i);
            getPaths_DFS(graph, e.dest, dest, path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        getPaths_DFS(graph, 5, 1, new ArrayList<>());
    }
}
