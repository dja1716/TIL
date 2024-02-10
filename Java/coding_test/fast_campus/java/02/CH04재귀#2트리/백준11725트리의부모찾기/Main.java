import java.util.*;
import java.io.*;


public class Main {


    static int N;
    static HashMap<Integer, Set<Integer>> tree = new HashMap<>();
    static int[] answer;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++) {
            tree.put(i, new HashSet<>());
        }
        answer = new int[N+1];
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        compute(1);

        for(int i = 2; i <= N; i++) {
            sb.append(answer[i]);
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        bw.write(new String(sb));
        bw.flush();
    }

    static void compute(int parentNode) {
        for(int childNode : tree.get(parentNode)) {
            answer[childNode] = parentNode;
            tree.get(childNode).remove(parentNode);
            compute(childNode);
        }
    }
}