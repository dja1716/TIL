import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int out = 2;
    static int nextOut = 3;
    static int visited = 4;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int iceCount = 0;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    iceCount++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            map[i][0] = out;
            map[i][M - 1] = out;
        }

        for(int j = 0; j < M; j++) {
            map[0][j] = out;
            map[N - 1][j] = out;
        }

        while(iceCount > 0) {
            ans++;

            checkOut(0, 0);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    clear(i,j);
                }
            }

            
            for(int i = 1; i < N - 1; i++) {
                for(int j = 1; j < M - 1; j++) {
                    process(i,j);
                }
            }

            for(int i = 1; i < N - 1; i++) {
                for(int j = 1; j < M - 1; j++) {
                    if(map[i][j] == nextOut) {
                        map[i][j] = out;
                        iceCount--;
                    }
                }
            }

        }
        bw.write(ans + "");
        bw.flush();
    }

    static void checkOut(int i, int j) {
        if(map[i][j] == visited || map[i][j] == 1) return;

        map[i][j] = visited;
        for(int k = 0; k < dx.length; k++) {
            if(i + dx[k] < 0 || i + dx[k] == N) continue;
            if(j + dy[k] < 0 || j + dy[k] == M) continue;
            checkOut(i + dx[k], j + dy[k]);
        }
    }

    static void clear(int i, int j) {
        if(map[i][j] == visited) {
            map[i][j] = out;
        }
    }

    static void process(int i, int j) {
        if(map[i][j] != 1) return;
        int cnt = 0;
        
        for(int k = 0; k < dx.length; k++) {
            if(map[i+dx[k]][j+dy[k]] == out) {
                cnt++;
            }
        }
        if(cnt >= 2) {
            map[i][j] = nextOut;
        }
    }
}