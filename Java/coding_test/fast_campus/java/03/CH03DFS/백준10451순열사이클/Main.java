import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


	static int N;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] graph = new int[n + 1];
			boolean[] visited = new boolean[n + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				graph[i] = Integer.parseInt(st.nextToken());
			}
			int it = 0;
			for (int i = 1; i <= n; i++) {
				if (visited[i]) {
					continue;
				}
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				it++;
				while (!q.isEmpty()) {
					int node = q.poll();
					if (!visited[node]) {
						q.add(graph[node]);
						visited[node] = true;
					}
				}
			}
			answer.append(it);
			answer.append('\n');
		}
		answer.deleteCharAt(answer.length() - 1);
		bw.write(new String(answer));
		bw.flush();
	}

}
