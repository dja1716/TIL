import java.util.*;
import java.io.*;


public class Main {
    static int N, r, c;
    static int[] pow;
    static int[] rc;
    static int[][] base;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        pow = new int[N];
        rc = new int[N];
        base = new int[2][2];
        int temp = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                base[i][j] = temp++;
            }
        }
        pow[0] = 4;
        rc[0] = 2;
        for(int i = 1; i < N; i++) {
            rc[i] = rc[i-1]*2;
            pow[i] = rc[i] * rc[i];

        }
        int answer = solve();
        bw.write(answer + "");
        bw.flush();
    }


    static int solve() {
        int m = Math.max(r, c);
        int n = 0;
        for(int i = 0; i < N; i++) {
            if(rc[i] > m) {
                n = i;
                break;
            }
        }
        return helper(n, r, c);
    }

    static int helper(int n, int row, int col) {
        if(n == 0) {
            return base[row][col];
        }
        if(row < rc[n-1] && col < rc[n-1]) {
            return helper(n-1, row, col);
        } else if(row >= rc[n-1] && col >= rc[n-1]) {
            return helper(n-1, row - rc[n-1], col - rc[n-1]) + 3 * pow[n-1];
        } else if(row >= rc[n-1]) {
            return helper(n-1, row - rc[n-1], col) + 2 * pow[n-1];
        } else {
            return helper(n-1, row, col - rc[n-1]) +  pow[n-1];
        }
    }
}