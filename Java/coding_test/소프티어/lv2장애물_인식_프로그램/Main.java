import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static List<Integer> list = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] row = st.nextToken().toCharArray();

            map[i] = row;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int res = search(i, j);
                if(res > 0) {
                    list.add(res);
                }
            }
        }
        bw.write(list.size() + "\n");
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
    }

    static int search(int i,int j) {
        if(map[i][j] == '0') {
            return 0;
        }
        map[i][j] = '0';
        int result = 1;
        for(int k = 0; k < dx.length; k++) {
            if(i + dx[k] < 0 || i + dx[k] == N) continue;
            if(j + dy[k] < 0 || j + dy[k] == N) continue;
            result += search(i + dx[k], j + dy[k]);
        }
        return result;
    }
}
