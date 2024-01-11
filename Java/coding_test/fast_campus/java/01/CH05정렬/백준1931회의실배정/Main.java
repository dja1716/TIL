import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Meeting[] meetings;
    static int answer;
    static int curEnd = -1;

    static class Meeting implements Comparable<Meeting> {
        int startTime;
        int endTime;

        Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Main.Meeting o) {
            // TODO Auto-generated method stub

            if(this.endTime != o.endTime) {
                return this.endTime - o.endTime;
            } else {
                return this.startTime - o.startTime;
            }
        }
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        meetings = new Meeting[N];


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int tempS = Integer.parseInt(st.nextToken());
            int tempE = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(tempS, tempE);
        }

        Arrays.sort(meetings);

        for(int i = 0; i < N; i++) {
            if(curEnd <= meetings[i].startTime) {
                curEnd = meetings[i].endTime;
                answer++;
            }
        }

        bw.write(answer + "");
        bw.flush();
    }

}
