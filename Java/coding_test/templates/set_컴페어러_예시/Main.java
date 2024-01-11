package Java.coding_test.templates.set_컴페어러_예시;
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Set<String> log = new HashSet();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            String action = st.nextToken();

            if(action.equals("enter")) {
                log.add(name);
            } else {
                log.remove(name);
            }
        }
        List<String> answer = new ArrayList<>(log);

        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        Collections.sort(answer, customComparator);
        
        for(String name : answer) {
            bw.write(name + '\n');
        }

        bw.flush();
    }

}
