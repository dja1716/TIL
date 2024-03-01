import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, K;

	static int[] dp;    // 무게 기준
	static int[][] arr;

	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K + 1];
		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // weight
			arr[i][1] = Integer.parseInt(st.nextToken()); // value
		}

		for (int i = 0; i < N; i++) {
			for (int k = K; k >= 0; k--) {
				if (k - arr[i][0] < 0) {
					break;
				}
				if (k - arr[i][0] == 0 || dp[k - arr[i][0]] > 0) {
					dp[k] = Math.max(dp[k], dp[k - arr[i][0]] + arr[i][1]);
					answer = Math.max(answer, dp[k]);
				}

			}
		}

		bw.write(answer + "");
		bw.flush();

	}
}
