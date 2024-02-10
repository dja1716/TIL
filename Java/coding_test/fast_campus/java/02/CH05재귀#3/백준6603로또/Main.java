import java.util.*;
import java.io.*;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            int[] arr = new int[N];

            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            compute(arr, new ArrayList<>(), 0, N);
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length()-1);
        bw.write(new String(sb));
        bw.flush();
    }

    static void compute(int[] arr, List<Integer> list, int idx, int n) {
        if(list.size() == 6) {
            for(int num : list) {
                sb.append(num);
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append('\n');
            return;
        }
        if(idx == n) return;
        list.add(arr[idx]);
        compute(arr, list,idx + 1, n);
        list.remove(list.size()-1);
        compute(arr, list, idx + 1, n);
    }
}