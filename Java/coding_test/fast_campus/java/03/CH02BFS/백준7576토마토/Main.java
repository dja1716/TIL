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
	static int[][] board;
	static int cnt = 0;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int answer = -1;
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					cnt++;
				} else if (board[i][j] == 1) {
					Point p = new Point(i, j);
					q.add(p);
				}
			}
		}

		if (cnt > 0) {
			solve();
		} else {
			answer = 0;
		}
		bw.write(answer + "");
		bw.flush();
	}

	static void solve() {
		A:
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
					continue;
				}
				if (board[nx][ny] == 0) {
					board[nx][ny] = board[p.x][p.y] + 1;
					if (--cnt == 0) {
						answer = board[nx][ny] - 1;
						break A;
					}
					q.add(new Point(nx, ny));
				}
			}
		}
	}
}

class Point {

	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}