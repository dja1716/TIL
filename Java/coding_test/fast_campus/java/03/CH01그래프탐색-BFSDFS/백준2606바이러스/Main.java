import java.util.*;
import java.io.*;


public class Main {

    static int N, M;
    static boolean[] visited;
    static boolean[][] graph;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        graph = new boolean[N+1][N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            graph[p1][p2] = true;
            graph[p2][p1] = true;
        }

        dfs(1);
        bw.write(--answer + "");
        bw.flush();
    }

    static void dfs(int node) {
        if(visited[node]) return;

        visited[node] = true;
        answer++;

        for(int i = 1; i <= N; i++) {
            if(graph[node][i]) {
                dfs(i);
            }
        }
    }
}