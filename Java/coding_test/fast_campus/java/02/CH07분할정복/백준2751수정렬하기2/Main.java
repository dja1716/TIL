import java.util.*;
import java.io.*;


public class Main {

    static int N;
    static Set<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(Integer.parseInt(st.nextToken()));
        }

        for(int num : set) {
            sb.append(num);
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length()-1);

        bw.write(new String(sb));
        bw.flush();
    }
}