import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] coin, dp;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K + 1];
		coin = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
			if (coin[i] <= K) {
				dp[coin[i]] = 1;
			}
		}

		for (int i = 1; i <= K; i++) {
			for (int j = 0; j < N; j++) {
				if (i + coin[j] <= K) {
					if (dp[i] > 0) {
						if (dp[i + coin[j]] > 0) {
							dp[i + coin[j]] = Math.min(dp[i + coin[j]], dp[i] + 1);
						} else {
							dp[i + coin[j]] = dp[i] + 1;
						}
					}
				}
			}
		}

		bw.write((dp[K] > 0 ? dp[K] : -1) + "");
		bw.flush();
	}

}
