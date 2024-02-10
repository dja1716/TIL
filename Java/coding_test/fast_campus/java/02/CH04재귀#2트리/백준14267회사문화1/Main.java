import java.util.*;
import java.io.*;


public class Main {

    static int N,M;
    static Set<Integer>[] employees;
    static int[] answer;
    static int[] praise;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        employees = new Set[N+1];
        answer = new int[N+1];
        praise = new int[N+1];

        for(int i = 1; i <= N; i++) {
            employees[i] = new HashSet<>();
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(i == 1) continue;


            employees[parent].add(i);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            praise[first] += second;
        }

        travel(0, 1);

        for(int i = 1; i <= N; i++) {
            sb.append(answer[i]);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        bw.write(new String(sb));
        bw.flush();
    }

    static void travel(int sum, int nodeN) {
        answer[nodeN] = sum;

        for(int childNode : employees[nodeN]) {
            travel(sum + praise[childNode], childNode);
        }
    }
}