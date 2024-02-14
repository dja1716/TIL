import java.util.*;
import java.io.*;


public class Main {
    static int answer = Integer.MAX_VALUE;
    static int[][] board = new int[10][10];

    static int[] left = {0, 5, 5, 5, 5, 5};
    static int N = 10;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0, 0);

        bw.write((answer == Integer.MAX_VALUE ? -1 : answer) + "");
        bw.flush();
    }

    static void solve(int r, int c, int count) {
        if(r == N) {
            answer = Math.min(answer, count);
            return;
        }
        int[] nextPos = next(r, c);
        if(board[r][c] == 0) {

            solve(nextPos[0], nextPos[1], count);
            return;
        }

        for(int i = 1; i <= 5; i++) {
            if(isPossible(r, c, i)) {
                consume(r, c, i);
                left[i]--;
                solve(nextPos[0], nextPos[1], count+1);
                left[i]++;
                restore(r, c, i);
            }
        }
    }

    static int[] next(int r, int c) {
        if(c == N -1) {
            c = 0;
            r++;
        } else {
            c++;
        }
        return new int[]{r, c};
    }

    static void consume(int r, int c, int n) {
        for(int i = r; i < r + n; i++) {
            for(int j = c; j < c + n; j++) {
                board[i][j] = 0;
            }
        }
    }

    static void restore(int r, int c, int n) {
        for(int i = r; i < r + n; i++) {
            for(int j = c; j < c + n; j++) {
                board[i][j] = 1;
            }
        }
    }
    

    static boolean isPossible(int r, int c, int n) {
        if(left[n] <= 0 || r + n > N|| c + n > N) return false;

        for(int i = r; i < r + n; i++) {
            for(int j = c; j < c + n; j++) {
                if(board[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}