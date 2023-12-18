import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        T = Integer.parseInt(st.nextToken());
        ans = new int[T];

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            compute(i, H, W, N);
            
        }
        for(int i = 0; i < T; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
    }

    public static void compute(int i, int H, int W, int N) {
        int X = N / H + 1;
        int Y = N % H;

        if(N % H == 0) {
            X = N / H;
            Y = H;
        }
        ans[i] = X + Y * 100;
    }
}
