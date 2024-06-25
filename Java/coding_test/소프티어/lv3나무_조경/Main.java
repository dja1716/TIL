package Java.coding_test.소프티어.lv3나무_조경;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter bw;
    static int answer = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        pre();
        solve();
    }

    static void solve() throws IOException {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                DFS(1, 0, i, j);
            }
        }
        bw.write(answer + "");
        bw.flush();
    }

    static void DFS(int depth, int sum, int cx, int cy) {
        
        if(depth > 4) return;

        for(int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visited[nx][ny]) continue;
            
            int nextSum = sum + board[cx][cy] + board[nx][ny];
            answer = Math.max(answer, nextSum);
            visited[nx][ny] = true;
            visited[cx][cy] = true;
            for(int j = cx + cy + 1; j < N * N; j++) {
                if(visited[j / N][j % N]) continue;
                DFS(depth + 1, nextSum, j / N, j % N);
            }
            visited[nx][ny] = false;
            visited[cx][cy] = false;
        }
        
    }

    static void pre() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}