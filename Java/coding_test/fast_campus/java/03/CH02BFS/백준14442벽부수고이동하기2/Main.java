import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[][] map;
	static int[][][] visited;
	static int answer = -1;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M][K + 1];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = in.charAt(j) - '0';
			}
		}
		solve();
		bw.write(answer + "");
		bw.flush();
	}


	static void solve() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0, 0, 0));
		visited[0][0][0] = 1;

		while (!q.isEmpty()) {
			Pos now = q.poll();
			if (now.x == N - 1 && now.y == M - 1) {
				answer = visited[N - 1][M - 1][now.bCount];
				return;
			}
			int nextCost = visited[now.x][now.y][now.bCount] + 1;
			for (int i = 0; i < dx.length; i++) {
				int nx = dx[i] + now.x;
				int ny = dy[i] + now.y;
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				if (map[nx][ny] == 0 && visited[nx][ny][now.bCount] == 0) {
					q.add(new Pos(nx, ny, now.bCount));
					visited[nx][ny][now.bCount] = nextCost;
				}
				if (map[nx][ny] == 1 && now.bCount < K && visited[nx][ny][now.bCount + 1] == 0) {
					q.add(new Pos(nx, ny, now.bCount + 1));
					visited[nx][ny][now.bCount + 1] = nextCost;
				}

			}
		}
	}
}

class Pos {

	int x;
	int y;
	int bCount;

	Pos(int x, int y, int b) {
		this.x = x;
		this.y = y;
		this.bCount = b;
	}
}

