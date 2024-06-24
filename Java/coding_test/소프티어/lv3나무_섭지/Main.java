package Java.coding_test.소프티어.lv3나무_섭지;

import java.io.*;
import java.util.*;

// BFS 사용
// 유령이 먼저 도착하면 안됨
public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] ghostMap;
    static boolean[][] visited;
    static Node startPos = new Node();
    static Node endPos = new Node();
    static List<Node> ghostList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ghostMap = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                ghostMap[i][j] = Integer.MAX_VALUE;

            }
        }
        for(int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(row[j] == '#') {
                    map[i][j] = -1; // 벽
                } else if(row[j] == 'N') {
                    startPos.x = i;
                    startPos.y = j;
                } else if(row[j] == 'G') {
                    ghostList.add(new Node(i, j));
                } else if(row[j] == 'D') {
                    endPos.x = i;
                    endPos.y = j;
                }
            }
        }
        pre();
        solve();
        
    }

    static void solve() {
        Queue<Integer> q = new LinkedList<>();
        q.add(startPos.x);
        q.add(startPos.y);
        visited[startPos.x][startPos.y] = true;

        while(!q.isEmpty()) {
            int cx = q.poll();
            int cy = q.poll();
            int cost = map[cx][cy] + 1;

            for(int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(nx == endPos.x && ny == endPos.y) {
                    System.out.print("Yes");
                    return;
                }
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == -1) continue;
                if(cost < ghostMap[nx][ny]) {
                    map[nx][ny] = cost;
                    visited[nx][ny] = true;
                    q.add(nx);
                    q.add(ny);
                }
            }
        }


        
        System.out.print("No");
    }

    static void pre() {
        Queue<Integer> q = new LinkedList<>();
        
        for(Node ghost : ghostList) {
            q.add(ghost.x);
            q.add(ghost.y);
            ghostMap[ghost.x][ghost.y] = 0;
        }

        while(!q.isEmpty()) {
            int cx = q.poll();
            int cy = q.poll();
            int cost = ghostMap[cx][cy] + 1;
            for(int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(ghostMap[nx][ny] <= cost) continue;
                ghostMap[nx][ny] = cost;
                q.add(nx);
                q.add(ny);
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
    Node() {
        x = 0;
        y = 0;
    }
}
