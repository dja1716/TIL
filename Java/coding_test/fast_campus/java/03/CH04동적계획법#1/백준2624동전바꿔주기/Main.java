import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int T, K;
	static int[][] dp;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K + 1][T + 1];
		arr = new int[K + 1][2];
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		dp[0][0] = 1;
		for (int i = 1; i <= K; i++) {
			int value = arr[i][0];
			int cnt = arr[i][1];

			for (int j = 0; j <= T; j++) {
				for (int k = 0; k <= cnt; k++) {
					if (j + value * k > T) {
						break;
					}
					dp[i][j + value * k] += dp[i - 1][j];
				}
			}
		}

		bw.write(dp[K][T] + "");
		bw.flush();

	}
}
