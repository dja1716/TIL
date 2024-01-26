import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    static int[][] workTimes;
    static int[] moveTimes;
    static int[][] answers;
    static int[][] shortest;

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        
        workTimes = new int[N][K];
        answers = new int[N][K];
        moveTimes = new int[N];
        shortest = new int[N][2];
        int tempTill = N - 1;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < K; j++) {
                workTimes[i][j] = Integer.parseInt(st.nextToken());
            }
            if(i < tempTill) {
                moveTimes[i] = Integer.parseInt(st.nextToken());
            }
            
        }
        
        for(int j = 0; j < K; j++) {
            answers[0][j] = workTimes[0][j];
        }
        for(int i = 1; i < N; i++) {
                
            for(int j = 0; j < K; j++) {
                if(shortest[i-1][0] == 0 || shortest[i-1][0] > answers[i-1][j]) {
                    shortest[i-1][0] = answers[i-1][j];
                    shortest[i-1][1] = j;
                }
            }
            for(int j = 0; j < K; j++) {
                int option1 = answers[i-1][j];
                int option2 = (j != shortest[i-1][1]) ? shortest[i-1][0] + moveTimes[i-1] : Integer.MAX_VALUE;
                answers[i][j] = Math.min(option1, option2) + workTimes[i][j];
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