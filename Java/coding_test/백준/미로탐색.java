package coding_test.백준;
import java.io.*;
import java.util.*;

public class 미로탐색 {
    static int N,M;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N][M];
        map = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            String input = bf.readLine();
            
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        
        BFS(0, 0);
        
        System.out.println(map[N-1][M-1]);
        
    }
    
    private static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()) {
            int now[] = q.poll();
            for(int k = 0; k < 4; k++) {
                int newX = now[0] + dx[k];
                int newY = now[1] + dy[k];
                
                if(newX >= 0 && newY >= 0 && newX < N && newY < M) {
                    if(map[newX][newY] != 0 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        map[newX][newY] = map[now[0]][now[1]] + 1;
                        q.add(new int[]{newX, newY});
                    }
                }
            }
        }

    }
}
