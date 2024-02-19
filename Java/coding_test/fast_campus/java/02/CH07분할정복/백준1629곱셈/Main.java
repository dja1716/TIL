import java.util.*;
import java.io.*;


public class Main {

    static long A,B,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        long answer = solve(A, B);
        bw.write(answer + "");
        bw.flush();
    }

    static long solve(long a, long b) {
        if(b == 1) {
            return a % C;
        } else if(b % 2 == 1) {
            long result = solve(a, b / 2) % C;
            return ((result * result) % C * a) % C;
        } else {
            long result = solve(a, b / 2) % C;
            return (result * result) % C;
        }
    }
}