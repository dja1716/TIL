import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] W;
    static boolean[] best;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        W = new int[N];
        best = new boolean[N];
        Arrays.fill(best, true);
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx1 = Integer.parseInt(st.nextToken()) - 1;
            int idx2 = Integer.parseInt(st.nextToken()) - 1;

            if(W[idx1] >= W[idx2]) {
                best[idx2] = false;
            }
            if(W[idx1] <= W[idx2]) {
                best[idx1] = false;
            }
        }

        int answer = 0;

        for(int i = 0; i < N; i++) {
            if(best[i]) answer++;
        }

        bw.write(answer + "");
        bw.flush();
    }
}
