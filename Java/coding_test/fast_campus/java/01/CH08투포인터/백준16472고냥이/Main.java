import java.util.*;
import java.io.*;

public class Main {
    static HashMap<Character, Integer> charMap = new HashMap<>();
    static char[] input;
    static int N;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        input = st.nextToken().toCharArray();

        int nextIdx = 0;
        for(int i = 0; i < input.length; i++) {
            while(nextIdx < input.length) {
                if(charMap.containsKey(input[nextIdx])) {
                    charMap.put(input[nextIdx], charMap.get(input[nextIdx]) + 1);
                } else {
                    if(charMap.size() >= N) {
                        break;
                    } else {
                        charMap.put(input[nextIdx], 1);
                    }
                }
                nextIdx++;
            }
            answer = Math.max(nextIdx - i, answer);
            if(charMap.get(input[i]) > 1) {
                charMap.put(input[i], charMap.get(input[i]) - 1);
            } else {
                charMap.remove(input[i]);
            }
        }
        bw.write(answer + "");
        bw.flush();
    }
}