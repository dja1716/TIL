import java.util.*;
import java.io.*;


public class Main {

    static int N;
    static int[][] map;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++) {
            rec(1, 1, 0, 0);
        }

        bw.write(answer + "");
        bw.flush();
    }

    static void rec(int s, int c, int cnt, int cost) {
        if(s == c && cnt > 0 && cnt < N) {
            return;
        }
        if(cnt == N) {
            if(s != c) return;
            answer = Math.min(answer, cost);
        }

        for(int i = 1; i <= N; i++) {
            if(map[c][i] > 0 && !visited[i]) {
                visited[i] = true;
                rec(s, i, cnt + 1, cost + map[c][i]);
                visited[i] = false;
            }
        }
    }
}