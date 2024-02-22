import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


	static boolean[][] map = new boolean[5][5];
	static int answer = 0;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};

	static List<Integer> list = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			for (int j = 0; j < 5; j++) {
				if (input.charAt(j) == 'S') {
					map[i][j] = true;
				}
			}
		}
		solve(0);
		bw.write(answer + "");
		bw.flush();
	}

	static void solve(int idx) {
		if (list.size() == 7) {
			if (computeSCount() < 4) {
				return;
			}
			if (bfs() != 7) {
				return;
			}
			answer++;
			return;
		}
		if (idx >= 25) {
			return;
		}

		list.add(idx);
		solve(idx + 1);
		list.remove(list.size() - 1);
		solve(idx + 1);
	}

	static int computeSCount() {
		int sCnt = 0;
		for (int idx : list) {
			sCnt += map[idx / 5][idx % 5] ? 1 : 0;
		}
		return sCnt;
	}

	static int bfs() {
		int cnt = 0;
		boolean[][] selectMap = new boolean[5][5];
		boolean[][] visitMap = new boolean[5][5];
		Queue<Integer> q = new LinkedList<>();

		for (int idx : list) {
			selectMap[idx / 5][idx % 5] = true;
		}
		q.add(list.get(0));

		while (!q.isEmpty()) {
			int idx = q.poll();
			int oldX = idx / 5;
			int oldY = idx % 5;

			for (int i = 0; i < dx.length; i++) {
				int newIdx = idx + dx[i] * 5 + dy[i];
				int newX = oldX + dx[i];
				int newY = oldY + dy[i];
				if (newX < 0 || newX >= 5 || newY < 0 || newY >= 5) {
					continue;
				}
				if (!visitMap[newIdx / 5][newIdx % 5] && selectMap[newIdx / 5][newIdx % 5]) {
					visitMap[newIdx / 5][newIdx % 5] = true;
					cnt++;
					q.add(newIdx);
				}
			}
		}
		return cnt;
	}
}