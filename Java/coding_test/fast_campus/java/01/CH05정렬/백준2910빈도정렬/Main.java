import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Long[] msg;
    static HashMap<Long, Integer> freqency = new HashMap<>();
    static HashMap<Long, Integer> order = new HashMap<>();
    

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        msg = new Long[N];
        int orderIndex = 0;
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            Long temp = Long.parseLong(st.nextToken());
            msg[i] = temp;
            int curFreq = freqency.getOrDefault(temp, 0);
            freqency.put(temp, curFreq + 1);
            if(!order.containsKey(temp)) {
                order.put(temp, orderIndex);
                orderIndex++;
            }
        }


        Comparator<Long> c1 = new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                int f1 = freqency.get(o1);
                int f2 = freqency.get(o2);
                if(f1 != f2) {
                    return f2 - f1;
                } else {
                    return order.get(o1) - order.get(o2);
                }
            }
        };
        Arrays.sort(msg, c1);

        for(Long m : msg) {
            bw.write(m.toString() + " ");
        }

        bw.flush();
    }

}
