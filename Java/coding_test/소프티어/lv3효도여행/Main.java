import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Map<Integer, Map<Integer, Character>> routes = new HashMap<>();
    static boolean[] visited;
    static String hRoute;
    static int answer = 0;

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        hRoute = st.nextToken();

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            char c = st.nextToken().toCharArray()[0];
            if(routes.containsKey(startNode)) {
                routes.get(startNode).put(endNode, c);
            } else {
                Map temp = new HashMap<>();
                temp.put(endNode, c);
                routes.put(startNode, temp);
            }
            if(routes.containsKey(endNode)) {
                routes.get(endNode).put(startNode, c);
            } else {
                Map temp = new HashMap<>();
                temp.put(startNode, c);
                routes.put(endNode, temp);
            }
        }
        
        BFS(1, "");
        bw.write(answer + "");
        bw.flush();
    }

    public static void BFS(int node, String str) {
        visited[node] = true;
        if(routes.get(node).size() == 1 && str.length() != 0) {
            compute(str, hRoute);
            return;
        }
        
        Map<Integer, Character> temp = routes.get(node);

        for(int key : temp.keySet()) {
            if(visited[key]) continue;

            BFS(key, str + temp.get(key));
        }
    }


    public static void compute(String str1, String str2) {
        
        int m = str1.length() + 1;
        int n = str2.length() + 1;
        int[][] dp = new int[m][n];

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        answer = Math.max(answer, dp[m-1][n-1]);
    }
}