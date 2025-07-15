import java.util.*;

public class Kosaraju_Algo{

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

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topologicalSort(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s){
        visited[curr]= true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e= graph[curr].get(i);
            if(!visited[e.dest]){
                topologicalSort(graph, e.dest, visited, s);
            }
        }

        s.push(curr);
    }

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean visited[]){
        visited[curr]= true;
        System.out.print(curr+" ");

        for(int i=0; i<graph[curr].size(); i++){
            Edge e= graph[curr].get(i);
            if(!visited[e.dest]){
                DFS(graph, e.dest, visited);
            }
        }

    }

    public static void Kosaraju(ArrayList<Edge> graph[]){
        //step 1
        boolean visited[]= new boolean[graph.length];
        Stack<Integer> s= new Stack<>();
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                topologicalSort(graph, i, visited, s);
            }
        }

        //step2
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transpose[]= new ArrayList[graph.length];
        for(int i=0; i<graph.length; i++){
            visited[i]= false;
            transpose[i]= new ArrayList<>();
        }

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e= graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        //step3
        while(!s.isEmpty()){
            int el= s.pop();
            if(!visited[el]){
                System.out.print("SCC->");
                DFS(transpose, el, visited);
                System.out.println();
            }
        }


    }

    public static void main(String[] args) {
        int V=5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        Kosaraju(graph);

    }
}