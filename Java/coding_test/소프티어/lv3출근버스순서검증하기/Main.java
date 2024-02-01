import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long answer = 0;
    static int[][] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N+1][N];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                if(arr[i] > arr[j]) {
                    dp[arr[i]][j] = 1;
                }
                dp[arr[i]][j] += dp[arr[i]][j-1];
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(arr[i] < arr[j]) {
                    answer += dp[arr[i]][N-1] - dp[arr[i]][j];
                }
            }
        }

        bw.write(answer + "");
        bw.flush();
    }
}
