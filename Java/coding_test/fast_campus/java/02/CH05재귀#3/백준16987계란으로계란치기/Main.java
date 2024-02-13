import java.util.*;
import java.io.*;


public class Main {

    static int N;
    static int[] W;
    static int[] D;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = new int[N];
        D = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            D[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
        }

        rec(0, 0);


        bw.write(answer + "");
        bw.flush();
    }

    static void rec(int idx, int brokeCnt) {
        if(idx == N || brokeCnt + 1 == N) {
            answer = Math.max(answer, brokeCnt);
            return;
        }
        if(D[idx] <= 0) {
            rec(idx+1, brokeCnt);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(i != idx && D[i] > 0) {
                D[i] -= W[idx];
                D[idx] -= W[i];
                int curBroke = D[i] <= 0 ? 1 : 0;
                curBroke = D[idx] <= 0 ? curBroke + 1 : curBroke;
                rec(idx+1,curBroke + brokeCnt);
                D[i] += W[idx];
                D[idx] += W[i];
            }
        }
    }

}