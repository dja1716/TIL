import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[] hArr, pArr;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        hArr = new boolean[N];
        pArr = new boolean[N];

        st = new StringTokenizer(br.readLine());
        char[] line = st.nextToken().toCharArray();
        for(int i = 0; i < N; i++) {
            if(line[i] == 'H') {
                hArr[i] = true;
            }
            if(line[i] == 'P') {
                pArr[i] = true;
            }
        }

        for(int i = 0; i < N; i++) {
            if(!pArr[i]) continue;
            int start = Math.max(0, i - K);
            int end = Math.min(N, i + K + 1);

            for(int j = start; j < end; j++) {
                if(hArr[j]) {
                    ans++;
                    hArr[j] = false;
                    break;
                }
            }
        }

        bw.write(ans + "");
        bw.flush();
    }
}
