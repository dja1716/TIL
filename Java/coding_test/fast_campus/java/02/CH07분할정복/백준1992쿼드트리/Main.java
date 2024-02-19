import java.util.*;
import java.io.*;


public class Main {

    static int N;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for(int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }


        dc(N, 0, 0);

        bw.write(new String(sb));
        bw.flush();
    }

    static void dc(int n, int x, int y) {

        if(isSame(n, x, y)) {
            sb.append(board[x][y]);
            return;
        }

        int newN = n / 2;

        sb.append('(');
        dc(newN, x, y);
        dc(newN, x, y + newN);
        dc(newN, x + newN, y);
        dc(newN, x + newN, y + newN);
        sb.append(')');
    }
    static boolean isSame(int n, int x, int y) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[x][y] != board[x+i][y+j])
                    return false;
            }
        }
        return true;
    }

}