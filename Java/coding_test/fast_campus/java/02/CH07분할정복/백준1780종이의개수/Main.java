import java.util.*;
import java.io.*;


public class Main {

    static int N;
    static int[][] board;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = -1; i <= 1; i++) {
            map.put(i, 0);
        }

        dc(0, 0, N);

        for(int i = -1; i <= 1; i++) {
            sb.append(map.get(i));
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length()-1);
        bw.write(new String(sb));
        bw.flush();
    }

    static void dc(int x, int y, int n) {
        if(n == 1  || isSame(x, y, n)) {
            map.put(board[x][y], map.get(board[x][y])+1);
            return;
        }

        int newN = n / 3;
        dc(x, y, newN);
        dc(x + newN, y, newN);
        dc(x + newN * 2, y ,newN);
        dc(x, y + newN, newN);
        dc(x + newN, y + newN, newN);
        dc(x + newN * 2, y + newN,newN);
        dc(x, y  + newN * 2, newN);
        dc(x + newN, y  + newN * 2, newN);
        dc(x + newN * 2, y  + newN * 2 ,newN);

    }


    static boolean isSame(int startX, int startY, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[startX][startY] != board[startX+i][startY+j]) {
                    return false;
                }
            }
        }
        return true;
    }
}