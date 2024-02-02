import java.io.*;
import java.util.*;

public class Main {
    static boolean isSecret = false;
    static int M, N, K;
    static int[] mArr;
    static int[] nArr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        mArr = new int[M];
        nArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < N; i++) {
            int j = 0;
            for(; j < M; j++) {
                if(i + j >= N) break;
                if(nArr[i+j] != mArr[j]) {
                    break;
                }
            }
            if(j == M) {
                isSecret = true;
                break;
            }
        }

        bw.write(isSecret ? "secret" : "normal");
        bw.flush();
    }
}
