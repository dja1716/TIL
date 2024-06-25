package Java.coding_test.소프티어.lv2전광판;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] board;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    
    public static void main(String[] args) throws IOException {
        pre();

        solve();
        
    
    }
    static void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n1P = 5, n2P = 5;
            int count = 0;
            for(int i = 1; i <= 10000; i *= 10) {
                if(n1 / i == 0) {
                    n1P--;
                }
                if(n2 / i == 0) {
                    n2P--;
                }
            }

            for(int i = 0; i < 5; i++) {
                boolean[] c1;
                boolean[] c2;
                int div = (int) Math.pow(10, 4 - i);
                if(n1P >= 5 - i) {
                    c1 = board[(n1 / div % 10)];
                } else {
                    c1 = board[10];
                }

                if(n2P >= 5 - i) {
                    c2 = board[n2 / div % 10];
                } else {
                    c2 = board[10];
                }
                for(int j = 0; j < c1.length; j++) {
                    if(c1[j] == c2[j]) continue;
                    count++;
                }
            }
            sb.append(count + "\n");
        }
        bw.write(new String(sb));
        bw.flush();
    }

    static void pre() {
        board = new boolean[11][7];
        board[0] = new boolean[]{true, true, true, true, true, true, false};
        board[1] = new boolean[]{true, true, false, false, false, false, false};
        board[2] = new boolean[]{false, true, true, false, true, true, true};
        board[3] = new boolean[]{true, true, true, false, false, true, true};
        board[4] = new boolean[]{true, true, false, true, false, false, true};
        board[5] = new boolean[]{true, false, true, true, false, true, true};
        board[6] = new boolean[]{true, false, true, true, true, true, true};
        board[7] = new boolean[]{true, true, true, true, false, false, false};
        board[8] = new boolean[]{true, true, true, true, true, true, true};
        board[9] = new boolean[]{true, true, true, true, false, true, true};
    }
}
