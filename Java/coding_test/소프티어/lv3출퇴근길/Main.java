package Java.coding_test.소프티어.lv3출퇴근길;

import java.io.*;
import java.util.*;

public class Main {
    static int S, T, N, M;
    static Map<Integer, Set<Integer>> adj;
    static Map<Integer, Set<Integer>> adjR;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        pre();
        solve();
    }

    static void solve() {
        visited[0][T] = true;
        DFS(S, adj, visited[0]);
        visited[1][S] = true;
        DFS(T, adj, visited[1]);
        DFS(S, adjR, visited[2]);
        DFS(T, adjR, visited[3]);
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            boolean add = true;
            for(int j = 0; j < 4; j++) {
                if(!visited[j][i]){ 
                    add = false;
                    break;
                }
            }
            if(add && i != S && i != T) answer++;
        }
        System.out.println(answer);
    }

    static void DFS(int curIdx, Map<Integer, Set<Integer>> graph, boolean[] v) {
        if (graph.get(curIdx) == null) return; // Null 체크 추가
        Set<Integer> curG = graph.get(curIdx);

        for(int next : curG) {
            if(!v[next]) {
                v[next] = true;
                DFS(next, graph, v);
            }
        }
    }

    static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        adj = new HashMap<>();
        adjR = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[4][N + 1];
        for (int i = 1; i <= N; i++) {
            adj.put(i, new HashSet<>());
            adjR.put(i, new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj.get(start).add(end);
            adjR.get(end).add(start);
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
    }
}
