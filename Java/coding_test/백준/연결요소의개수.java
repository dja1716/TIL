package coding_test.백준;
import java.util.*;
import java.io.*;

public class 연결요소의개수 {
    public static void main(String[] args) throws IOException {
        // get input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int nodeN = Integer.parseInt(st.nextToken());
        int edgeN = Integer.parseInt(st.nextToken());
        
        // stack
        Stack<Integer> stack = new Stack<>();
        // graph
        int[][] graph = new int[edgeN][2];
        // visited
        boolean[] visited = new boolean[nodeN];
        int count = 0;
        
        for(int i = 0; i < edgeN; i++) {
            st = new StringTokenizer(bf.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
        }
        
        while(true) {
            int next = getNotVisited(visited);
            if(next == -1) {
                break;
            }
            count++;
            stack.push(next);
            while(!stack.isEmpty()) {
                int nowVisited = stack.pop();
                if(visited[nowVisited - 1]) continue;
                
                
                visited[nowVisited - 1] = true;
                for(int i = 0; i < edgeN; i++) {
                    if(graph[i][0] == nowVisited) {
                        if(!visited[graph[i][1] - 1]) {
                            stack.push(graph[i][1]);
                        }
                    }
                    if(graph[i][1] == nowVisited) {
                        if(!visited[graph[i][0] - 1])  {
                            stack.push(graph[i][0]);
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
    
    private static int getNotVisited(boolean[] visited) {
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) return i + 1;
        }
        return -1;
    }
}
