import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        // get input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int nodeN = Integer.parseInt(st.nextToken());
        int edgeN = Integer.parseInt(st.nextToken());
        
        // graph
        graph = new ArrayList[nodeN + 1];
        // visited
        visited = new boolean[nodeN + 1];
        int count = 0;
        
        for(int i = 1; i < nodeN + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < edgeN; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        
        for(int i = 1; i < nodeN + 1; i++) {
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }
        
        System.out.println(count);
    }
    
    private static void DFS(int v) {
        if(visited[v]) return;
        visited[v] = true;
        for(int i : graph[v]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}
