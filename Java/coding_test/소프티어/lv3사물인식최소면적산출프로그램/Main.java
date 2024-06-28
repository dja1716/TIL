package Java.coding_test.소프티어.lv3사물인식최소면적산출프로그램;

import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, List<Node>> xy = new HashMap<>();
    static int[][] board;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int answer = 2000 * 2000;
    public static void main(String[] args) throws IOException {
        pre();
        solve();
    }

    static void solve() {
        DFS(1, 0, 0, 0, 0);
        System.out.println(answer);
        
    }

    static void DFS(int idx, int minX, int minY, int maxX, int maxY) {
        if(idx == K + 1) {
            answer = Math.min(answer, (maxX - minX) * (maxY - minY));
            return;
        }
        List<Node> nodes = xy.get(idx);
        for(Node node : nodes) {
            if(idx == 1) {
                DFS(idx + 1, node.x, node.y, node.x, node.y);
                continue;
            }

            
            int newMinX = minX <= node.x ? minX : node.x;
            int newMinY = minY <= node.y ? minY : node.y;
            int newMaxX = maxX >= node.x ? maxX : node.x;
            int newMaxY = maxY >= node.y ? maxY : node.y;
            if((newMaxX - newMinX) * (newMaxY - newMinY) >= answer) continue;
            DFS(idx + 1, newMinX, newMinY, newMaxX, newMaxY);
        }
        
    }

    static void pre() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        board = new int[N][3];
        
        for(int i = 1; i <= K; i++) {
            xy.put(i, new ArrayList<>());
        }
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            xy.get(board[i][2]).add(new Node(board[i][0], board[i][1]));
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