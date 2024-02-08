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

        compute(new LinkedHashSet<>(), M);

        bw.write(new String(sb));
        bw.flush();
    }


    static void compute(Set<Integer> s, int n) {
        if(n == 0) {
            for(Integer value : s) {
                sb.append(value);
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append('\n');
        } else {
            for(int i = 0; i < input.length; i++) {
                if(!s.contains(input[i])) {
                    s.add(input[i]);
                    compute(s, n - 1);
                    s.remove(input[i]);
                }
            }
        }
    }

}