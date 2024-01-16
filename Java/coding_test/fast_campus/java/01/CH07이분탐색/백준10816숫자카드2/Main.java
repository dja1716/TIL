import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static HashMap<Integer, Integer> nMap = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(nMap.containsKey(num)) {
                nMap.put(num, nMap.get(num) + 1);
            } else {
                nMap.put(num, 1);
            }
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while(M-- > 1) {
            int num = Integer.parseInt(st.nextToken());
            bw.write(nMap.getOrDefault(num, 0) + " ");
        }

        int num = Integer.parseInt(st.nextToken());
        bw.write(nMap.getOrDefault(num, 0) + "");
        bw.flush();
    }
}
