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
			int input = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());

			solve(input, goal);
		}
		answer.deleteCharAt(answer.length() - 1);
		bw.write(new String(answer));
		bw.flush();
	}

	static void solve(int input, int goal) {
		Queue<Register> q = new LinkedList<>();
		q.add(new Register(input));
		boolean[] visited = new boolean[10000];

		while (!q.isEmpty()) {
			Register cur = q.poll();

			Register D = new Register(cur);
			D.D();
			if (D.number == goal) {
				answer.append(D.path);
				answer.append('\n');
				return;
			}
			Register S = new Register(cur);
			S.S();
			if (S.number == goal) {
				answer.append(S.path);
				answer.append('\n');
				return;
			}
			Register L = new Register(cur);
			L.L();
			if (L.number == goal) {
				answer.append(L.path);
				answer.append('\n');
				return;
			}

			Register R = new Register(cur);
			R.R();
			if (R.number == goal) {
				answer.append(R.path);
				answer.append('\n');
				return;
			}

			if (!visited[D.number]) {
				q.add(D);
				visited[D.number] = true;
			}
			if (!visited[S.number]) {
				q.add(S);
				visited[S.number] = true;
			}
			if (!visited[L.number]) {
				q.add(L);
				visited[L.number] = true;
			}
			if (!visited[R.number]) {
				q.add(R);
				visited[R.number] = true;
			}
		}
	}

}

class Register {

	int number;
	StringBuilder path;

	Register(int number) {
		this.number = number;
		this.path = new StringBuilder();
	}

	Register(Register r) {
		this.number = r.number;
		this.path = new StringBuilder(r.path);
	}

	void trim() {
		if (number < 0) {
			number += 10000;
		}
		number = number % 10000;
	}

	void D() {
		number *= 2;
		trim();
		path.append('D');
	}

	void S() {
		number -= 1;
		trim();
		path.append('S');
	}

	void L() {
		int d4 = number / 1000;
		number = number % 1000 * 10 + d4;
		path.append('L');
	}

	void R() {
		int d1 = number % 10;
		number = number / 10 + d1 * 1000;
		path.append('R');
	}
}