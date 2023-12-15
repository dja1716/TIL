import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String answer = "";
        int N = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());

        while(N > 0) {
            String A;
            int temp = N % mod;
            if(temp >= 10) {
                A = String.valueOf((char) (temp + 'A' - 10));
            } else {
                A = String.valueOf(temp);
            }
            answer = A + answer;
            N /= mod;
        }

        bw.write(answer);
        bw.flush();
    }
}
