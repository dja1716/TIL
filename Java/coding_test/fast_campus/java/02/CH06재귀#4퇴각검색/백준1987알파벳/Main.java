import java.util.*;
import java.io.*;


public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int R,C;
    static char[][] board;

    static Set<Character> visited = new HashSet<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            char[] line = st.nextToken().toCharArray();
            board[i] = line;
        }
        rec(0, 0, 0);
        bw.write(answer + "");
        bw.flush();
    }

    public static void rec(int result, int x, int y) {
        if(visited.contains(board[x][y])) {
            return;
        }
        visited.add(board[x][y]);
        answer = Math.max(answer, ++result);

        for(int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX < 0 || newX >= R || newY < 0 || newY >= C)
                continue;

            rec(result, newX, newY);
        }
        visited.remove(board[x][y]);
    }
}