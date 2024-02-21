import java.util.*;
import java.io.*;


public class Main {

    static int N, M, start;

    static Map<Integer, Set<Integer>> graph;

    static boolean[] visited;
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        graph = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            graph.put(i, new TreeSet<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }

        dfs(start);
        resetVisited();
        bfs(start);

        dfsResult.deleteCharAt(dfsResult.length()-1);
        bfsResult.deleteCharAt(bfsResult.length()-1);
        bw.write(new String(dfsResult) + "\n");
        bw.write(new String(bfsResult));
        bw.flush();
    }

    static void dfs(int node) {

        if(visited[node]) {
            return;
        }
        visited[node] = true;
        dfsResult.append(node);
        dfsResult.append(' ');

        for(int nextNode : graph.get(node)) {
            dfs(nextNode);
        }
    }

    static void bfs(int start) {
        Queue<Integer> bfsQ = new LinkedList<>();
        bfsQ.add(start);
        while(!bfsQ.isEmpty()) {
            int node = bfsQ.poll();
            if(visited[node]) continue;
            visited[node] = true;
            bfsResult.append(node);
            bfsResult.append(' ');

            bfsQ.addAll(graph.get(node));
        }

    }

    static void resetVisited() {
        Arrays.fill(visited, false);
    }
}