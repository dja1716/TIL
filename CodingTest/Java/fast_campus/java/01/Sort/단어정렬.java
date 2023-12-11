import java.util.*;
import java.io.*;

public class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];

        for(int i = 0; i < N; i++) {
            arr[i] = bf.readLine();
        }

        Arrays.sort(arr, (str1, str2) -> {
            if(str1.length() == str2.length()) {
                return str1.compareTo(str2);
            }
            return str1.length() - str2.length();
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < N; i++) {
            if(i > 0 && arr[i].equals(arr[i-1])) continue;
            bw.write(arr[i] + "\n");
        }

        bw.flush();
    }
}
