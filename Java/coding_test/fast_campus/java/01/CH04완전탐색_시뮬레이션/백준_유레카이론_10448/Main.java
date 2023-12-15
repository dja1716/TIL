import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int max = 45;
    static int[] arrN = new int[max];
    static int T;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        T = Integer.parseInt(st.nextToken());


        for(int i = 1; i <= 44; i++) {
            arrN[i] = i * (i + 1) / 2;
        }

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int target = Integer.parseInt(st.nextToken());
            bw.write(isPossible(target) + "\n");
        }
        bw.flush();
    }

    public static int isPossible(int target) {
        int result = 0;
        outerLoop:
        for(int i = 1; i < max; i++) {
            for(int j = 1; j < max; j++) {
                for(int k = 1; k < max; k++) {
                    int temp = arrN[i] + arrN[j] + arrN[k];
                    if(temp == target) {
                        result = 1;
                        break outerLoop;
                    }
                    if(temp > target) break;
                }
            }
        }
        return result;
    }
}
