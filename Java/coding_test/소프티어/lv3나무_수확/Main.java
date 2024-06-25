package Java.coding_test.소프티어.lv3나무_수확;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int answer = 0;
    static int N;
    static int[][] board;
    static int[][][] dp;
    
    public static void main(String[] args) throws IOException {
        pre();
        solve();
    }

    static void solve() throws IOException {

        dp[0][0][0] = board[0][0];
        dp[0][0][1] = board[0][0] * 2;

        for(int i = 1; i < N; i++) {
            dp[0][i][0] = dp[0][i - 1][0] + board[0][i];
            dp[0][i][1] = Math.max(dp[0][i][0] + board[0][i], dp[0][i-1][1] + board[0][i]);

            dp[i][0][0] = dp[i - 1][0][0] + board[i][0];
            dp[i][0][1] = Math.max(dp[i][0][0] + board[i][0], dp[i-1][0][1] + board[i][0]);
            
        }
        for(int i = 1; i < N; i++) {
            for(int j = 1; j < N; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i][j-1][0]) + board[i][j];
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i][j-1][1]) + board[i][j];

                dp[i][j][1] = Math.max(dp[i][j][1], dp[i][j][0] + board[i][j]);
            }
        }
        
        bw.write(dp[N-1][N-1][1] + "");
        bw.flush();
    }

    
    
    static void pre() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N][N][2];
        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

