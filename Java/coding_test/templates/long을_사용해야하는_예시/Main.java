import java.io.*;
import java.util.*;

public class Main {

    static int K, N;
    static int max = -1;
    static int[] lines;
    static long answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lines = new int[K];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            lines[i] = temp;
            if(temp > max) {
                max = temp;
            }
        }
        Arrays.sort(lines);
        bs();
        bw.write(answer + "");
        bw.flush();

    }

    static void bs() {
        long l = 1;
        long r = max;
        while(l <= r) {
            int tempTotal = 0;
            long mid = (l + r) / 2;
            for(int i = K - 1; i >= 0; i--) {
                int temp = (int) (lines[i] / mid);
                if(temp == 0) break;
                tempTotal += temp;
                if(tempTotal >= N) break;
            }
            if(tempTotal >= N) {
                answer = Math.max(mid, answer);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }
}
