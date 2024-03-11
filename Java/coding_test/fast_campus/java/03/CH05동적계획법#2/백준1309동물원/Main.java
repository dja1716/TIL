import java.util.Scanner;

public class Main {

	static int N;
	static int[][] dp;
	static int div = 9901;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		dp = new int[N][3];

		for (int i = 0; i < 3; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < N; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % div;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % div;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % div;
		}

		long answer = 0;
		for (int i = 0; i < 3; i++) {
			answer = (answer + dp[N - 1][i]) % div;
		}

		System.out.println(answer);

	}
}
