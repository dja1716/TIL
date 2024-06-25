package Java.coding_test.소프티어.lv3순서대로_방문하기;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static boolean[][] visited;
    static int[][] dest;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static Map<Integer, Set<Integer>> points = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        pre();
        solve();
    }

    static void solve() throws IOException {
        visited[dest[0][0]][dest[0][1]] = true;
        DFS(0, dest[0][0], dest[0][1]);

        System.out.println(answer);
    }

    static void DFS(int idx, int x, int y) {
        if(dest[idx][0] == x && dest[idx][1] == y) {
            idx++;
       } else if(points.get(x).contains(y)) {
            return;
       }
        
        // System.out.println(x + " " + y + " " + idx);
        if(idx == M) {
            answer++;
            
            return;
        }

        for(int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 1 || ny < 1 || nx > N || ny > N) continue;

            if(visited[nx][ny]) continue;
            visited[nx][ny] = true;
            
            DFS(idx, nx, ny);
            visited[nx][ny] = false;
            
        }
    }
    
    static void pre() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1][N+1];
        dest = new int[M][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) {
                    visited[i+1][j+1] = true;
                }
            }
            points.put(i+1, new HashSet<>());
        }

        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dest[i][0] = x;
            dest[i][1] = y;
            points.get(x).add(y);
        }
    }
}
