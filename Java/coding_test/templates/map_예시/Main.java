import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String answer;
    static int curCount;
    static Map<String, Integer> books = new HashMap();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        String bookTemp = st.nextToken();
        books.put(bookTemp, 1);
        curCount = 1;
        answer = bookTemp;

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String bookTemp2 = st.nextToken();
            Integer tempCount = books.getOrDefault(bookTemp2, 0) + 1;
            
            books.put(bookTemp2, tempCount);
            if(curCount < tempCount) {
                answer = bookTemp2;
                curCount = tempCount;
            } else if(curCount == tempCount && answer.compareTo(bookTemp2) > 0) {
                answer = bookTemp2;
                curCount = tempCount;
            }
        }


        bw.write(answer);
        bw.flush();
    }

}
