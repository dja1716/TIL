import java.util.*;

public class Main {
    static int[][] board;
    static int N;
    static int count;
    static int cur;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        board = new int[N][N];
        count = 0;
        cur = 1;
        
        recursion(0);
        
        System.out.println(count);
    }
    
    public static void recursion(int k) {
        if(k == N) {
            count++;
        } else {
            for(int i = 0; i < N; i++) {
                if(board[k][i] == 0) {
                    // change map
                    board[k][i] = k;
                    
                    changeBoard(k, i);
                    cur++;
                    
                    recursion(k+1);
                    cur--;
                    // put map back
                    revertBoard();
                    board[k][i] = 0;
                }
            }
        }
    }
    
    public static void revertBoard() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == cur) {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    public static void changeBoard(int k, int i) {
        // row && column
        for(int j = 0; j < N; j++) {
            if(board[k][j] == 0) {
                board[k][j] = cur;
            }
            if(board[j][i] == 0) {
                board[j][i] = cur;
            }
        }
        // diag 1 +
        for(int j = 1; j + k < N && j + i < N; j++) {
            if(board[j+k][j+i] == 0) {
                board[j+k][j+i] = cur;
            }
        }
        // diag 1 - 
        for(int j = 1; j + k < N && i - j >= 0; j++) {
            if(board[j+k][i-j] == 0) {
                board[k+j][i-j] = cur;
            }
        }
        // diag 2 +
        for(int j = 1; k - j >= 0 && j + i < N; j++) {
            if(board[k-j][i+j] == 0) {
                board[k-j][i+j] = cur;
            }
        }
        // diag 2 -
        for(int j = 1; k - j >= 0 && i - j >= 0; j++) {
            if(board[k-j][i-j] == 0) {
                board[k-j][i-j] = cur;
            }
        }
        
    }
}
