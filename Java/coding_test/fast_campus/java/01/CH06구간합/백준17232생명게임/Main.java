import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int T;
    static int K;
    static int a;
    static int b;
    static int[][] map;
    static int[][] accMap;



    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        accMap = new int[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] temp = st.nextToken().toCharArray();
            for(int j = 1; j <= M; j++) {
                if(temp[j-1] == '*') {
                    map[i][j] = 1;
                }
            }
        }

        while(T-- > 0) {
            makePrefixSumMap();
            process();
        }

        for(int i = 1; i < N; i++) {
            for(int j = 1; j <= M; j++) {
                if(map[i][j] == 1) {
                    bw.write('*');
                } else {
                    bw.write('.');
                }
            }
            bw.write('\n');
        }
        for(int j = 1; j <= M; j++) {
            if(map[N][j] == 1) {
                bw.write('*');
            } else {
                bw.write('.');
            }
        }

        bw.flush();
    }

    public static void makePrefixSumMap() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                accMap[i][j] = map[i][j] + accMap[i-1][j] + accMap[i][j-1] - accMap[i-1][j-1];
            }
        }
    }

    public static void process() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                int r1 = Math.max(i - K, 1);
                int c1 = Math.max(j - K, 1);
                int r2 = Math.min(i + K, N);
                int c2 = Math.min(j + K, M);

                int totalNearBy = accMap[r2][c2] - accMap[r1 - 1][c2] - accMap[r2][c1 - 1] + accMap[r1-1][c1-1] - map[i][j];
                if(map[i][j] == 1) {
                    if(totalNearBy < a || totalNearBy > b) {
                        map[i][j] = 0;
                    }
                } else {
                    if(totalNearBy > a && totalNearBy <= b) {
                        map[i][j] = 1;
                    }
                }
            }
        }
    }
}
