import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 위
                if(i > 0) {
                    char from = map[i][j];
                    char to = map[i-1][j];
                    if(from != to) {
                        map[i-1][j] = from;
                        map[i][j] = to;
                        check();
                        map[i-1][j] = to;
                        map[i][j] = from;
                    }
                }
                // 아래
                if(i < N - 1) {
                    char from = map[i][j];
                    char to = map[i+1][j];
                    if(from != to) {
                        map[i+1][j] = from;
                        map[i][j] = to;
                        check();
                        map[i+1][j] = to;
                        map[i][j] = from;
                    }
                }
                // 왼
                if(j > 0) {
                    char from = map[i][j];
                    char to = map[i][j-1];
                    if(from != to) {
                        map[i][j-1] = from;
                        map[i][j] = to;
                        check();
                        map[i][j-1] = to;
                        map[i][j] = from;
                    }
                }
                // 오
                if(j < N - 1) {
                    char from = map[i][j];
                    char to = map[i][j+1];
                    if(from != to) {
                        map[i][j+1] = from;
                        map[i][j] = to;
                        check();
                        map[i][j+1] = to;
                        map[i][j] = from;
                    }
                }
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }

    public static void check() {

        for(int i = 0; i < N; i++) {
            char prevChar = 'X';
            int count = 0;
            for(int j = 0; j < N; j++) {
                if(map[i][j] == prevChar) {
                    count++;
                    answer = Math.max(count, answer);
                } else {
                    count = 1;
                    answer = Math.max(count, answer);
                    prevChar = map[i][j];

                }
            }
        }

        for(int i = 0; i < N; i++) {
            char prevChar = 'X';
            int count = 0;
            for(int j = 0; j < N; j++) {
                if(map[j][i] == prevChar) {
                    count++;
                    answer = Math.max(count, answer);
                } else {
                    count = 1;
                    answer = Math.max(count, answer);
                    prevChar = map[j][i];
                }
            }
        }

    }
}
