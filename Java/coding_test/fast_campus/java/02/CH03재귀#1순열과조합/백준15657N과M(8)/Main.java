import java.util.*;
import java.io.*;

public class Main {


    static int N;
    static int M;
    static int[] input;
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        compute(new ArrayList<>(), M, 0);

        bw.write(new String(sb));
        bw.flush();
    }


    static void compute(List<Integer> s, int n, int idx) {
        if(n == 0) {
            for(Integer value : s) {
                sb.append(value);
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append('\n');
        } else {
            for(int i = idx; i < input.length; i++) {
                s.add(input[i]);
                compute(s, n - 1, i);
                s.remove(s.size()-1);
            }
        }
    }

}