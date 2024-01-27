import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int answer = 0;
    static int[] stones;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        stones = new int[N];
        dp = new int[N];
        Arrays.fill(dp, 1);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(stones[j] < stones[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        bw.write(answer + "");
        bw.flush();
    }
}
