import java.io.*;
import java.util.*;

public class Main {
    static int W, N;
    static long answer = 0;
    static int[][] materials;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        materials = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            materials[i][0] = Integer.parseInt(st.nextToken());
            materials[i][1] = Integer.parseInt(st.nextToken());
        }


        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[]r1, int[]r2) {
                return r2[1] - r1[1];
            }
        };
        Arrays.sort(materials, comp);
        for(int i = 0; i < N; i++) {
            if(W == 0) break;
            int weight = Math.min(W, materials[i][0]);

            W -= weight;
            answer += weight * materials[i][1];
        }
        bw.write(answer + "");
        bw.flush();
    }
}