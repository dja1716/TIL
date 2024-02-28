import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		int[] dp0 = new int[N + 1];
		int[] dp1 = new int[N + 1];
		int[] dp2 = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp0[1] = 0;
		dp1[1] = arr[1];
		dp2[1] = arr[1];

		for (int i = 2; i <= N; i++) {
			dp0[i] = Math.max(dp0[i - 1], Math.max(dp1[i - 1], dp2[i - 1]));
			dp1[i] = dp0[i - 1] + arr[i];
			dp2[i] = dp1[i - 1] + arr[i];
		}

		bw.write(Math.max(dp0[N], Math.max(dp1[N], dp2[N])) + "");
		bw.flush();
	}


}
