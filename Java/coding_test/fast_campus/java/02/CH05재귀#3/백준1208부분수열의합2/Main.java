import java.util.*;
import java.io.*;


public class Main {

    static int N, S;
    static int[] input;
    static Map<Integer, Integer> sumMap = new HashMap<>();
    static long answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        input = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int mid = N / 2;
        compute1(0, 0, mid);
        compute2(0, mid, N);
        if(S == 0) answer--;

        bw.write(answer + "");
        bw.flush();
    }

    static void compute1(int result, int idx, int end) {
        if(idx == end) {
            sumMap.put(result, sumMap.getOrDefault(result, 0) + 1);
            return;
        }
        compute1(result, idx+1, end);
        result += input[idx];
        compute1(result, idx+1, end);
    }

    static void compute2(int result, int idx, int end) {
        if(idx == end) {
            answer += sumMap.getOrDefault(S - result, 0);
            return;
        }
        compute2(result, idx+1, end);
        result += input[idx];
        compute2(result,idx+1, end);
    }
}