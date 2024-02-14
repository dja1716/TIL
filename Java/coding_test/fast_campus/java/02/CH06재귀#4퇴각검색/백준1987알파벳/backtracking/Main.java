import java.util.*;
import java.io.*;


public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int R,C;
    static int[][] board;
    static int[][] visitedArr;

    static Set<Integer> visited = new HashSet<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        visitedArr = new int[R][C];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j) - 'A';
            }
        }
        visitedArr[0][0] = 1 << (board[0][0]);
        visited.add(board[0][0]);
        rec(1, 0, 0);
        bw.write(answer + "");
        bw.flush();
    }

    public static void rec(int result, int x, int y) {

        for(int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX < 0 || newX >= R || newY < 0 || newY >= C)
                continue;
            int next = board[newX][newY];
            if(visited.contains(next)) {
                continue;
            }
            int route = 1 << next;
            if(visitedArr[newX][newY] == (visitedArr[x][y] | route)) continue;

            visitedArr[newX][newY] = visitedArr[x][y] | route;

            visited.add(next);
            rec(result + 1, newX, newY);
            visited.remove(next);
        }
        answer = Math.max(answer, result);
    }
}