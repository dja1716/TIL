package Java.coding_test.programmers.대표유형.BFS_DFS.아이템줍기;
import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
    static List<int[]> points = new ArrayList<>();
    static int[][] board = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    static int answer = 0;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        
        // 그리기
        for(int i = 0; i < rectangle.length; i++) {
            int[] rec = rectangle[i];
            draw(rec);
        }
        
        // outline
        outline();
        
        // 내부 삭제
        deleteInner();
        visited = new boolean[102][102];
        find(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer / 2;
    }
    
    public static void find(int x, int y, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            if(poll[0] == itemX && poll[1] == itemY) {
                answer = poll[2];
                return;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                int nc = poll[2] + 1;
                
                if(board[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, nc});
                }
            }
        }
    }
    
    public static void deleteInner() {
        for(int i = 0; i < points.size(); i++) {
            boolean delete = true;
            for(int j = 0; j < dx.length; j++) {
                int nx = points.get(i)[0] + dx[j];
                int ny = points.get(i)[1] + dy[j];
                
                if(board[nx][ny] == 2) {
                    delete = false;
                    break;
                }
            }
            
            if(delete) {
                board[points.get(i)[0]][points.get(i)[1]] = 0;
            }
        }
    }
    
    public static void outline() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            board[poll[0]][poll[1]] = 2;
            
            for(int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) continue;
                if(visited[nx][ny]) continue;
                
                if(board[nx][ny] == 1) continue;
                
                
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
    
    public static void draw(int[] rec) {
        int bottomX = rec[0] * 2;
        int bottomY = rec[1] * 2;
        int topX = rec[2] * 2;
        int topY = rec[3] * 2;
        
        
        for(int i = bottomX; i <= topX; i++) {
            board[i][topY] = 1;
            board[i][bottomY] = 1;
            points.add(new int[]{i, topY});
            points.add(new int[]{i, bottomY});
        }
        
        for(int i = bottomY; i <= topY; i++) {
            board[bottomX][i] = 1;
            board[topX][i] = 1;
            points.add(new int[]{bottomX, i});
            points.add(new int[]{topX, i});
        }
    }
}