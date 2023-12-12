package coding_test.백준;
import java.io.*;
import java.util.*;

public class 구간합구하기4Pro {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int SN = Integer.parseInt(st.nextToken());
        int QN = Integer.parseInt(st.nextToken());
        
        // get new line
        st = new StringTokenizer(bf.readLine());
        
        
        long[] S = new long[SN + 1];
        for(int i = 1; i <= SN; i++) {
            S[i] = S[i - 1] + Long.parseLong(st.nextToken());
        }
        long[] answers = new long[QN];
        for(int i = 0; i < QN; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            answers[i] = S[end] - S[start - 1];
        }
        for(int i = 0; i < QN; i++) {
            System.out.println(answers[i]);
        }
    }
}
