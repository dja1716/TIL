import java.io.*;
import java.util.*;

public class Main {
    static int div = 1000000007;
    static long N;
    static long K;
    static long P;
    static long answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        N = Long.parseLong(st.nextToken());
        
        N *= 10;

        answer = (K * (dc(P, N) % div)) % div;
        
        bw.write(answer + "");
        bw.flush();
    }

    public static long dc(long P, long N) {
        long result;
        if(N == 1) {
            return P;
        }
        result = dc(P, N / 2);
        if(N % 2 == 0) {
            return result * result % div;
        } else {
            return result * result % div * P % div;
        }
        
    }
}

