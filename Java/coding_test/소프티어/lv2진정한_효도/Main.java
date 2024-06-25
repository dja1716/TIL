package Java.coding_test.소프티어.lv2진정한_효도;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[][] board;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        pre();
        solve();
    }

    static void solve() throws IOException {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                helper(i, j);
            }
        }
        bw.write(answer + "");
        bw.flush();
    }

    static void helper(int x, int y) {
        // row
        int sum = 0;
        for(int i = 0; i < 3; i++) {
            if(i == y) continue;
            sum += Math.abs(board[x][y] - board[x][i]);
        }
        answer = Math.min(sum, answer);
        // col
        sum = 0;
        for(int i = 0; i < 3; i++) {
            if(i == x) continue;
            sum += Math.abs(board[x][y] - board[i][y]);
        }
        answer = Math.min(sum, answer);
    }
    
    static void pre() throws IOException {
        board = new int[3][3];
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

