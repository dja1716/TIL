import java.io.*;
import java.util.*;

public class Main {
    static char[] answer;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        answer = new char[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] S = st.nextToken().toCharArray();
            char[] T = st.nextToken().toCharArray();

            
            for(int j = 0; j < S.length; j++) {
                if(S[j] == 'x' || S[j] == 'X') {
                    answer[i] = T[j];
                    break;
                }
            }
        }
        bw.write(new String(answer).toUpperCase());
        bw.flush();
    }
}
