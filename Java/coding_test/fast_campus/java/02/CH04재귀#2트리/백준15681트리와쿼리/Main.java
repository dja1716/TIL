import java.util.*;
import java.io.*;


public class Main {


    static int N, R, Q;
    static HashMap<Integer, Set<Integer>> tree = new HashMap<>();
    static int[] answer;
    static int[] q;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        answer = new int[N+1];
        q = new int[Q];


        for(int i = 1; i <= N; i++) {
            tree.put(i, new HashSet<>());
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            tree.get(U).add(V);
            tree.get(V).add(U);
        }

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            q[i] = Integer.parseInt(st.nextToken());
        }

        travel(R);

        for(int i = 0; i < Q; i++) {
            sb.append(answer[q[i]]);
            sb.append('\n');
        }

        sb.deleteCharAt(sb.length()-1);
        bw.write(new String(sb));
        bw.flush();
    }
    static int travel(int nodeN) {
        int result = 1;
        for(int node : tree.get(nodeN)) {
            tree.get(node).remove(nodeN);
            result += travel(node);
        }
        answer[nodeN] = result;
        return result;
    }
}