import java.io.*;
import java.util.*;

public class Main {

    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o1) {
            if(this.end != o1.end) {
                return this.end - o1.end;
            }
            return o1.start - this.start;
        }
    }
    
    static int answer = 0;
    static int N;
    static int endTime;
    static Lecture[] lArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        lArr = new Lecture[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lArr[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lArr);

        for(int i = 0; i < N; i++) {
            if(lArr[i].start >= endTime) {
                endTime = lArr[i].end;
                answer++;
            }
        }

        bw.write(answer + "");
        bw.flush();
    }
}
