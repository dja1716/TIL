import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int max = 100001;
	static int[] visited = new int[max];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();
		bw.write(visited[K] + "");
		bw.flush();
	}

	public static void bfs() {

		Queue<Integer> q = new LinkedList<>();
		q.add(N);

		while (!q.isEmpty()) {
			int n = q.poll();
			if (n == K) {
				break;
			}
			int back = n - 1;
			int go = n + 1;
			int jump = 2 * n;
			int nextCost = visited[n] + 1;
			if (back >= 0 && visited[back] == 0) {
				visited[back] = nextCost;
				q.add(back);
			}
			if (go < max && visited[go] == 0) {
				visited[go] = nextCost;
				q.add(go);
			}
			if (jump < max && visited[jump] == 0) {
				visited[jump] = nextCost;
				q.add(jump);
			}
		}
	}
}