package Java.coding_test.소프티어.lv3효도_음식;

import java.io.*;
import java.util.*;

public class Main {
    static int[] sum;
    static int[] sumR;
    static int[] nums;
    
    static int[] dp;
    static int[] dpR;
    static int N;
    static int answer;

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        pre();
        solve();
    }

    static void solve() throws IOException {
        // 앞에서 dp 채우기
        sum[0] = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < N; i++) {
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
            dp[i] = Math.max(sum[i], dp[i-1]);

        }
        dpR[N-1] = nums[N-1];
        sumR[N-1] = nums[N-1];

        // 뒤에서부터 dpR 채우기
        for(int i = N - 2; i >= 0; i--) {
            sumR[i] = Math.max(nums[i], sumR[i + 1] + nums[i]);
            dpR[i] = Math.max(sumR[i], dpR[i+1]);
            
        }
        
        
        answer = dp[0] + dpR[2];
        //최댓값 찾기
        for(int i = 1; i < N - 1; i++) {
            answer = Math.max(answer, dp[i-1] + dpR[i+1]);
        }
        bw.write(answer + "");
        bw.flush();
    }

    static void pre() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        nums = new int[N];
        sum = new int[N];
        dp = new int[N];

        sumR = new int[N];
        dpR = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        
    }
}
