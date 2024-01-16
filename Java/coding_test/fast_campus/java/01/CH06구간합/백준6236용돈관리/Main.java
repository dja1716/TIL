import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] a;
    static int max = -1;
    static long answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            if(max < a[i]) {
                max = a[i];
            }
        }
        bs();
        bw.write(answer + "");
        bw.flush();
    }

    static void bs() {
        long l = max;
        long r = Integer.MAX_VALUE;

        while(l <= r) {
            long mid = (l + r) / 2;
            int k = 0;
            long left = 0;
            for(int i = 0; i < N; i++) {
                if(left - a[i] < 0) {
                    k++;
                    left = mid - a[i];
                } else {
                    left -= a[i];
                }
            }
            if(k <= M) {
                answer = Math.min(mid, answer);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
    }
}
