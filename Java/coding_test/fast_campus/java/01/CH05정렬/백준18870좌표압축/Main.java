import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer> inputArr = new ArrayList<>();
    static TreeSet<Integer> set = new TreeSet<>();
    static HashMap<Integer, Integer> map = new HashMap<>();
    

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            Integer x = Integer.parseInt(st.nextToken());
            set.add(x);
            inputArr.add(x);
        }
        Integer[] temp = set.toArray(new Integer[set.size()]);
        for(int i = 0; i < temp.length; i++) {
            map.put(temp[i], i);
        }
        
        for(int i = 0; i < inputArr.size(); i++) {
            bw.write(map.get(inputArr.get(i)).toString());
            if(i < inputArr.size() - 1) {
                bw.write(' ');
            }
        }
        
        bw.flush();
    }

}
