import java.util.*;
public class Cycle_Directed{

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
        //cycle-exists
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));  

        // cycle-does not exists
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));

        // graph[1].add(new Edge(1, 3));

        // graph[2].add(new Edge(2, 3));  

    }

    public static boolean isCycle(ArrayList<Edge> graph[]){
        boolean visited[]= new boolean[graph.length];
        boolean stack[]= new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                if(isCycleUtil(graph, i, visited, stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean visited[], boolean stack[]){
        visited[curr]= true;
        stack[curr]= true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e= graph[curr].get(i);
            if(stack[e.dest]){ //stack me already wo node aa chuka hai jispr jaana hai thus cycle
                return true;
            }

            if(!visited[e.dest] && isCycleUtil(graph, e.dest, visited, stack)){ // node is not visited toh uske liye agr cycle hai to true
                return true;
            }
        }
        stack[curr]= false;
        return false;

    }

    public static void main(String[] args) {
        int V=4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph));

    }
}