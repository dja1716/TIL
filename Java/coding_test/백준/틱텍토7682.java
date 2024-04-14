package Java.coding_test.백준;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class 틱텍토7682 {
  
}


public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("end")) {
				break;
			}
			char[] cArr = command.toCharArray();

			char[][] board = new char[3][3];
			int xCount = 0;
			int yCount = 0;
			int idx = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					board[i][j] = cArr[idx];
					if (cArr[idx] == 'X') {
						xCount++;
					} else if (cArr[idx] == 'O') {
						yCount++;
					}
					idx++;
				}
			}
			if (xCount > 5 || yCount > 4) {
				sb.append("invalid\n");
				continue;
			}
			int diff = xCount - yCount;
			if (diff != 0 && diff != 1) {
				sb.append("invalid\n");
				continue;
			}

			int xSuccess = 0;
			int ySuccess = 0;

			for (int i = 0; i < 3; i++) {
				if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
					if (board[i][0] == 'X') {
						xSuccess++;
					} else if (board[i][0] == 'O') {
						ySuccess++;
					}
				}
				if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
					if (board[0][i] == 'X') {
						xSuccess++;
					} else if (board[0][i] == 'O') {
						ySuccess++;
					}
				}
			}
			if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
				if (board[1][1] == 'X') {
					xSuccess++;
				} else if (board[1][1] == 'O') {
					ySuccess++;
				}
			}
			if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
				if (board[1][1] == 'X') {
					xSuccess++;
				} else if (board[1][1] == 'O') {
					ySuccess++;
				}
			}
			if (xSuccess > 0 && ySuccess > 0) {
				sb.append("invalid\n");
				continue;
			}
			if (xSuccess > 0 && xCount - yCount != 1) {
				sb.append("invalid\n");
				continue;
			}
			if (ySuccess > 0 && xCount != yCount) {
				sb.append("invalid\n");
				continue;
			}
			if (xSuccess == 0 && ySuccess == 0 && xCount + yCount != 9) {
				sb.append("invalid\n");
				continue;
			}
			sb.append("valid\n");
		}
		bw.write(new String(sb));
		bw.flush();
	}
}
