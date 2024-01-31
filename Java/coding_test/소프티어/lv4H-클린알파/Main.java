import java.io.*;
import java.util.*;

public class Main {
    static long P, N;
    static long ans = 0;
    static long[] arr;
    static long div = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = Long.parseLong(st.nextToken());
        N = Long.parseLong(st.nextToken());
        arr = new long[(int)N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            long Ai = Long.parseLong(st.nextToken());
            arr[i] = Ai;
        }

        long powP = 1;
        for(int i = (int)N - 1; i >= 0; i--) {
            ans = (ans + powP * arr[i]) % div;
            powP = powP * P % div;
        }

        bw.write(ans + "");
        bw.flush();
    }
}
