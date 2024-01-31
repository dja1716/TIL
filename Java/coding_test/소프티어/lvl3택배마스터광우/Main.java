import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[] arr;
    static int answer =Integer.MAX_VALUE;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        used = new boolean[N];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        
        perm(new int[N], 0);

        bw.write(answer + "");
        bw.flush();
    }

    static void perm(int[] idxArr, int idx) {
        if(idx == N) {
            Queue<Integer> myQueue = new LinkedList<>();
            for(int v : idxArr){
                myQueue.offer(arr[v]);
            }
            
            int kCount = 0;
            int sum = 0;
            int total = 0;

            while(true){
                sum += myQueue.peek();
                myQueue.offer(myQueue.poll());
                
                if(sum + myQueue.peek() > M){
                    kCount++;
                    total += sum;
                    sum = 0;
                }

                if(kCount == K) break;
            }

            answer = Math.min(total, answer);
        } else {
            for(int i = 0; i < N; i++) {
                if(!used[i]) {
                    used[i] = true;
                    idxArr[idx] = i;
                    perm(idxArr, idx + 1);
                    used[i] = false;
                }
            }
        }
        
    }
}
