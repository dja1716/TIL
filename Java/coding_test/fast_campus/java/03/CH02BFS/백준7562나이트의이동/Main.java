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
	static Queue<Integer> answer = new LinkedList<>();
	static int[][] board = new int[301][301];
	static int[][] knightMove = {{-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2},
		{-1, -2}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int max = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			solve(max, sx, sy, dx, dy);
		}
		while (!answer.isEmpty()) {
			int cnt = answer.poll();
			bw.write(cnt + "\n");
		}
		bw.flush();
	}

	static void solve(int max, int sx, int sy, int dx, int dy) {
		Queue<Integer> deleteQ = new LinkedList<>();
		Queue<Integer> q = new LinkedList<>();

		q.add(sx);
		q.add(sy);

		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			if (x == dx && y == dy) {
				answer.add(board[x][y]);
				break;
			}
			for (int[] move : knightMove) {
				int nx = move[0] + x;
				int ny = move[1] + y;
				if (nx < 0 || ny < 0 || nx >= max || ny >= max) {
					continue;
				}
				if (board[nx][ny] == 0) {
					deleteQ.add(nx);
					deleteQ.add(ny);
					q.add(nx);
					q.add(ny);
					board[nx][ny] = board[x][y] + 1;
				}
			}

		}

		while (!deleteQ.isEmpty()) {
			int x = deleteQ.poll();
			int y = deleteQ.poll();
			board[x][y] = 0;
		}
	}
}