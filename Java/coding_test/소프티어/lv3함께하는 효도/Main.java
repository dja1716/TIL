package Java.coding_test.소프티어.lv3함께하는 효도;

import java.io.*;
import java.util.*;
// 시간 충분
// dfs 여러번
// 3초
public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static boolean[][][] visited;
    static int[][] board;
    static int sum = 0;
    static int answer = 0;
    static List<Node> friends = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N][M];
        board = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            friends.add(new Node(Integer.parseInt(st.nextToken()) - 1,
                                 Integer.parseInt(st.nextToken()) - 1));
        }
        solve();
    }

    static void solve() {
    
        for(int i = 0; i < friends.size(); i++) {
            visited[friends.get(i).x][friends.get(i).y][i] = true;
            sum += board[friends.get(i).x][friends.get(i).y];
            
        }
        answer = sum;
        DFS(0, 0, friends.get(0).x, friends.get(0).y);
        System.out.println(answer);
    }

    static void DFS(int m, int t, int x, int y) {
        if(t >= 3) {
            if(m + 1 >= M) {
                answer = Math.max(sum, answer);
                return;
            }
            
            DFS(m + 1, 0, friends.get(m + 1).x, friends.get(m + 1).y);
            return;
        }
        for(int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visited[nx][ny][m]) continue;
            boolean add = true;
            for(int j = 0; j < M; j++) {
                if(visited[nx][ny][j]) {
                    add = false;
                    break;
                }
            }
            visited[nx][ny][m] = true;
            if(add) {
                sum += board[nx][ny];
            }
            DFS(m, t + 1, nx, ny);
            visited[nx][ny][m] = false;
            if(add) {
                sum -= board[nx][ny];
            }
        }
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
