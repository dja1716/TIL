import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] scores;
    static int[] accScores;
    static float[] answers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        scores = new int[N + 1];
        answers = new float[K];
        accScores = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++) {
            accScores[i] = accScores[i-1] + scores[i];
        }

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            float answer = (float) (accScores[end] - accScores[start-1]) / (end - start + 1);
            bw.write(String.format("%.2f", answer) + "\n");
        }
        bw.flush();
    }
}