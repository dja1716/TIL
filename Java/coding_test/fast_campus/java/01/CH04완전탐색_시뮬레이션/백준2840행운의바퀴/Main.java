import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] steps;
    static char[] dest;
    static char[] ans;
    static boolean possible = true;
    static int curIdx;
    static HashSet<Character> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        ans = new char[N];
        for(int i = 0; i < N;i++) {
            ans[i] = '?';
        }

        steps = new int[K];
        dest = new char[K];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            steps[i] = Integer.parseInt(st.nextToken());
            dest[i] = st.nextToken().charAt(0);
        }

        curIdx = 0;
        if(possible) {
            for(int i = K - 1; i >= 0; i--) {
                if(ans[curIdx] != '?' && ans[curIdx] != dest[i]) {
                    possible = false;
                    break;
                }
                ans[curIdx] = dest[i];
                curIdx = (curIdx + steps[i]) % N;
            }
        }

        if(possible) {
            for(int i = 0; i < N; i++) {
                if(ans[i] == '?') continue;
                if(set.contains(ans[i])) {
                    possible = false;
                    break;
                }
                set.add(ans[i]);
            }
        }


        if(!possible) {
            bw.write('!');
        } else {
            for(int i = 0; i < N; i++) {
                bw.write(ans[i]);
            }
        }

        bw.flush();
    }

}
