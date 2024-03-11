import java.io.IOException;
import java.util.Scanner;

public class Main {

	static int N;
	static long[][] dp;
	static int div = 1000000000;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		dp = new long[N][10];

		for (int i = 0; i < 10; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][1];
			for (int j = 1; j < 9; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % div;
			}
			dp[i][9] = dp[i - 1][8];
		}

		long answer = 0;
		for (int i = 1; i < 10; i++) {
			answer = (answer + dp[N - 1][i]) % div;
		}

		System.out.println(answer);

	}
}
