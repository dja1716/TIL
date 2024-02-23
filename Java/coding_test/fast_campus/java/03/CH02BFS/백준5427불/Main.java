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
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		while (N-- > 0) {
			solve();
		}
		answer.deleteCharAt(answer.length() - 1);
		bw.write(new String(answer));
		bw.flush();
	}


	static void solve() throws IOException {
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] fireMap = new int[H][W];
		int[][] pathMap = new int[H][W];
		Queue<Point> fireQ = new LinkedList<>();
		Queue<Point> pathQ = new LinkedList<>();
		boolean[][] visitMap = new boolean[H][W];

		for (int i = 0; i < H; i++) {
			String input = br.readLine();
			for (int j = 0; j < W; j++) {
				if (input.charAt(j) == '#') {
					//wall
					fireMap[i][j] = pathMap[i][j] = -1;
				} else if (input.charAt(j) == '@') {
					pathQ.add(new Point(i, j));
				} else if (input.charAt(j) == '*') {
					fireQ.add(new Point(i, j));
					pathMap[i][j] = -1;
				}
			}
		}

		while (!fireQ.isEmpty()) {
			Point firePos = fireQ.poll();
			int nextCost = fireMap[firePos.x][firePos.y] + 1;

			for (int i = 0; i < dx.length; i++) {
				int nx = firePos.x + dx[i];
				int ny = firePos.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
					continue;
				}
				if (fireMap[nx][ny] == -1 || (visitMap[nx][ny])) {
					continue;
				}
				visitMap[nx][ny] = true;
				fireMap[nx][ny] = nextCost;
				fireQ.add(new Point(nx, ny));
			}
		}
		visitMap = new boolean[H][W];
		while (!pathQ.isEmpty()) {
			Point pathPos = pathQ.poll();
			int nextCost = pathMap[pathPos.x][pathPos.y] + 1;

			for (int i = 0; i < dx.length; i++) {
				int nx = pathPos.x + dx[i];
				int ny = pathPos.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
					answer.append(nextCost);
					answer.append('\n');
					return;
				}
				if (pathMap[nx][ny] == -1 || (fireMap[nx][ny] > 0 && fireMap[nx][ny] <= nextCost)) {
					continue;
				}
				if (visitMap[nx][ny]) {
					continue;
				}

				visitMap[nx][ny] = true;

				pathMap[nx][ny] = nextCost;
				pathQ.add(new Point(nx, ny));
			}
		}

		answer.append("IMPOSSIBLE\n");
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