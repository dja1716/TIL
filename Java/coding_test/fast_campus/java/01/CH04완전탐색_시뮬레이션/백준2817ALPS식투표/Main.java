import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int totalVote;
    static int totalCandidate;
    static HashMap<String, Queue<Integer>> voteMap = new HashMap<>();
    static TreeMap<String, Integer> ansMap = new TreeMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        totalVote = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        totalCandidate = Integer.parseInt(st.nextToken());

        for(int i = 0; i < totalCandidate; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int vote = Integer.parseInt(st.nextToken());
            if((float)totalVote * 0.05f <= vote) {
                Queue<Integer> tempQ = new LinkedList<>();
                for(int k = 1; k <= 14; k++) {
                    tempQ.add(vote / k);
                }
                voteMap.put(name, tempQ);
                ansMap.put(name, 0);
            }


        }

        for(int i = 0; i < 14; i++) {
            String name = "";
            int vote = -1;

            for(String key : voteMap.keySet()) {
                if(voteMap.get(key).peek() > vote) {
                    name = key;
                    vote = voteMap.get(key).peek();
                }
            }
            voteMap.get(name).poll();
            ansMap.put(name, ansMap.get(name) + 1);
        }


        for(String key : ansMap.keySet()) {
            bw.write(key + " " + ansMap.get(key) + '\n');
        }
        
        bw.flush();
    }

}
