import java.util.*;

public class Kahn_Algo{

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
    
            graph[2].add(new Edge(2, 3));
    
            graph[3].add(new Edge(3, 1));
            
            graph[4].add(new Edge(4, 0));
            graph[4].add(new Edge(4, 1));
    
            graph[5].add(new Edge(5, 0));
            graph[5].add(new Edge(5, 2));
            
        }
    
        public static void calc_Indegree(ArrayList<Edge> graph[], int in_degree[]){
            for(int i=0; i<graph.length; i++){
                //vertex is i
                int vertex= i; // get all the neighbours of the vertex i
                for(int j=0; j<graph[vertex].size(); j++){
                    Edge e= graph[vertex].get(j);
                    in_degree[e.dest]++; // inc indegree of the destination nodes
                }
            }
        }

        public static void topologicalSort(ArrayList<Edge> graph[]){
            int in_degree[]= new int[graph.length];
            calc_Indegree(graph, in_degree);

            Queue<Integer> q= new LinkedList<>();
            
            // add the vertex in queue with indegree 0
            for(int i=0; i<in_degree.length; i++){
                if(in_degree[i] == 0){
                    q.add(i);
                }
            }

            while(!q.isEmpty()){
                int curr= q.remove();
                System.out.print(curr+" ");

                // for the vertex "curr" get all the neighbours and dec their indegree by -1
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e= graph[curr].get(i);
                    in_degree[e.dest]--;
                    if(in_degree[e.dest] == 0){
                        q.add(e.dest); // if the indegree of the dest becomes 0 that means no node before it thus add it to queue
                    }
                }
            }
            System.out.println();
        }

    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        topologicalSort(graph);
    }
}
