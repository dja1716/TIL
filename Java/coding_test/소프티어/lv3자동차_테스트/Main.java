package Java.coding_test.소프티어.lv3자동차_테스트;

import java.io.*;
import java.util.*;

public class Main {
    static int n, q;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Map<Integer, Integer> answers = new HashMap<>();
    public static void main(String[] args) throws IOException {
        pre();
        solve();
    }

    public static void solve() throws IOException {
        
        while(q-- > 0) {
            st = new StringTokenizer(br.readLine());
            bw.write(answers.getOrDefault(Integer.parseInt(st.nextToken()), 0) + "\n");
        }
        bw.flush();
    }

    static void pre() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i = 1; i < n - 1; i++) {
            answers.put(arr[i], i * (n - i - 1));
        }
    }
}
