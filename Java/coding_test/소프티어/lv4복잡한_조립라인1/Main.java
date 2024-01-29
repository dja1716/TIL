import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    static int[][] workTimes;
    static int[][][] moveTimes;
    static int[][] answers;

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        
        workTimes = new int[N][K];
        answers = new int[N][K];
        moveTimes = new int[N][K][K];
        int tempTill = N - 1;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < K; j++) {
                workTimes[i][j] = Integer.parseInt(st.nextToken());
            }
            if(i < tempTill) {
                for(int j = 0; j < K; j++) {
                    for(int m = 0; m < K; m++) {
                        if(m == j) continue;
                        moveTimes[i][j][m] = Integer.parseInt(st.nextToken());
                    }
                }
            }
        }
        
        for(int j = 0; j < K; j++) {
            answers[0][j] = workTimes[0][j];
        }
        for(int i = 1; i < N; i++) {

            for(int j = 0; j < K; j++) {
                int shortest = answers[i-1][j];
                for(int m = 0; m < K; m++) {
                    if(j == m) continue;
                    if(shortest > answers[i-1][m] + moveTimes[i-1][m][j]) {
                        shortest = answers[i-1][m] + moveTimes[i-1][m][j];
                    }
                }
                
                answers[i][j] = shortest + workTimes[i][j];
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int j = 0; j < K; j++) {
            answer = Math.min(answers[N-1][j], answer);
        }
        bw.write(answer + "");
        bw.flush();
    }
}