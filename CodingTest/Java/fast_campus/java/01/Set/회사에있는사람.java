import java.util.*;
import java.io.*;

public class 회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        Set<String> logSet = new HashSet();
        String[] names = new String[N];
        StringTokenizer st;


        for(int i = 0;i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            String action = st.nextToken();

            names[i] = name;
            if(action.equals("enter")) {
                logSet.add(name);
            } else {
                logSet.remove(name);
            }
        }
        // if wrong change
        Arrays.sort(names, Collections.reverseOrder());
        for(int i = 0; i < N; i++) {
            if(i > 0 && names[i].equals(names[i-1])) {
                continue;
            }
            if(logSet.contains(names[i])) {
                bw.write(names[i] + "\n");
            }
        }

        bw.flush();
    }
}
