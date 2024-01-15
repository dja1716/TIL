import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] acc;



    

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        acc = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());

            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                acc[i][j] = acc[i][j-1] + map[i][j];
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = process(x1, y1, x2, y2);

            bw.write(result + "\n");
        }


        bw.flush();
    }

    static int process(int x1, int y1, int x2, int y2) {
        int answer = 0;
        for(int i = x1; i <= x2; i++) {
            answer += acc[i][y2] - acc[i][y1 - 1];
        }
        return answer;
    }
}
