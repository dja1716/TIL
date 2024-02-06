import java.util.*;
import java.io.*;

public class Main {

    static class Element {
        int value;
        boolean chosen;

        Element(int value) {
            this.value = value;
            this.chosen = false;
        }
    }

    static int N;
    static Queue<Element> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int howMany = Integer.parseInt(st.nextToken());
            int wantToKnow = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();
            int[] arr = new int[10];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < howMany; i++) {
                int val = Integer.parseInt(st.nextToken());
                arr[val]++;
                Element e = new Element(val);

                if(i == wantToKnow) {
                    e.chosen = true;
                }

                q.add(e);
            }
            int itN = 0;
            outerLoop:
            for(int i = 9; i >= 1; i--) {
                while(arr[i] > 0) {
                    Element out = q.poll();

                    if(out.value == i) {
                        if(out.chosen) {
                            bw.write(++itN + "\n");
                            break outerLoop;
                        } else {
                            arr[i]--;
                            itN++;
                        }
                    } else {
                        q.add(out);
                    }
                }
            }
        }
        bw.flush();
    }
}