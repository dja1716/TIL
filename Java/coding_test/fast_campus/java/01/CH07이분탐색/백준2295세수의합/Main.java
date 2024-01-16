import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static HashSet<Integer> addSet = new HashSet<>();

    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }
        Arrays.sort(arr);
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                addSet.add(arr[i] + arr[j]);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                int target = arr[j] - arr[i];
                if(addSet.contains(target)) {
                    answer = Math.max(arr[j], answer);
                }
            }
        }
        bw.write(answer + "");
        bw.flush();
    }
}
