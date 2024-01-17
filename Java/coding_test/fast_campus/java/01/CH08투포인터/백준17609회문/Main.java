import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] wordArr;
    static int[] answers;


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        wordArr = new String[N];
        answers = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            wordArr[i] = st.nextToken();
        }

        for(int i = 0; i < N; i++) {
            char[] word = wordArr[i].toCharArray();
            int left = 0;
            int right = word.length - 1;
            int result = 0;
            while(left < right) {
                if(word[left] != word[right]) {
                    if(isPalindrome(word, left + 1, right) || isPalindrome(word, left, right - 1)) {
                        result = 1;
                    } else {
                        result = 2;
                    }
                    break;
                }
                left++;
                right--;
            }
            answers[i] = result;
        }
        for(int i = 0; i < N -1; i++) {
            bw.write(answers[i] + "\n");
        }
        bw.write(answers[N - 1] + "");
        bw.flush();

    }

    static boolean isPalindrome(char[] cArr, int left, int right) {
        while(left < right) {
            if(cArr[left] != cArr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
