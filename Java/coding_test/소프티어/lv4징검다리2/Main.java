import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] input;
    static int[] ans, ansR, dp, dpR;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        input = new int[N];
        ans = new int[N];
        ansR = new int[N];
        dp = new int[N];
        dpR = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = input[0];
        int idx = 0;
        ans[0] = 1;
        for(int i = 1; i < N; i++) {
            if(input[i] < dp[idx]) {
                int p = bs(0, idx, input[i], dp);
                ans[i] = p + 1;
                dp[p] = input[i];
            } else {
                idx++;
                ans[i] = idx + 1;
                dp[idx] = input[i];
            }
        }

        idx = 0;
        dpR[0] = input[N - 1];
        ansR[N-1] = 1;
        for(int i = N - 2; i >= 0; i--) {
            if(input[i] < dpR[idx]) {
                int p = bs(0, idx, input[i], dpR);
                ansR[i] = p + 1;
                dpR[p] = input[i];
            } else {
                idx++;
                ansR[i] = idx + 1;
                dpR[idx] = input[i];
            }
        }
        int answer = 0;
        for(int i = 0; i < N; i++) {
            answer = Math.max(answer, ans[i] + ansR[i]);
        }

        bw.write(answer - 1 + "");
        bw.flush();
        
    }
    // 1 3 5 <- 4
    static int bs(int left, int right, int target, int[] dpArr) {
        while(left < right) {
            int mid = (left + right) / 2;

            if(dpArr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
