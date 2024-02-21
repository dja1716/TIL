import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	static int N, M;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][] graph;
	static int answer = 0;
	static int leftCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] > 0) {
					leftCount++;
				}
			}
		}
		solve();

		bw.write(answer + "");
		bw.flush();
	}

	static void solve() {
		if (checkVanish()) {
			answer = 0;
			return;
		}
		if (checkSeg()) {
			return;
		}
		int[][] meltArr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				meltArr[i][j] = melt(i, j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] > 0) {
					if (meltArr[i][j] >= graph[i][j]) {
						leftCount--;
						graph[i][j] = 0;
					} else {
						graph[i][j] -= meltArr[i][j];
					}
				}
			}
		}
		answer++;
		solve();
	}

	static int melt(int i, int j) {
		int result = 0;
		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < N && j + dy[k] >= 0 && j + dy[k] < M
				&& graph[i + dx[k]][j + dy[k]] == 0) {
				result++;
			}
		}
		return result;
	}

	static boolean checkSeg() {
		int checkCount = 0;

		int[] start = new int[2];
		outerLoop:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] > 0) {
					start[0] = i;
					start[1] = j;
					break outerLoop;
				}
			}
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		boolean[][] visited = new boolean[N][M];
		while (!q.isEmpty()) {
			int[] element = q.poll();
			if (visited[element[0]][element[1]]) {
				continue;
			}
			visited[element[0]][element[1]] = true;
			checkCount++;
			for (int k = 0; k < dx.length; k++) {
				int newI = element[0] + dx[k];
				int newJ = element[1] + dy[k];
				if (newI >= 0 && newI < N && newJ >= 0 && newJ < M
					&& graph[newI][newJ] > 0) {
					q.add(new int[]{newI, newJ});
				}
			}
		}

		return checkCount != leftCount;
	}

	static boolean checkVanish() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] > 0) {
					return false;
				}
			}
		}
		return true;
	}
}