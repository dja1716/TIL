import java.util.*;

public class 수열정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];
        int[] S = new int[N];
        
        HashMap<Integer, Queue<Integer>> map = new HashMap();
        
        for(int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            
            P[i] = temp;
            S[i] = temp;
            map.put(temp, new LinkedList());
        }
        
        Arrays.sort(P);
        
        for(int i = 0; i < N; i++) {
            map.get(P[i]).add(i);
        }
        
        for(int i = 0; i < N; i++) {
            int result = map.get(S[i]).poll();
            
            if(i == N - 1) {
                System.out.print(result);
            } else {
                System.out.print(result + " ");
            }
        }
    }
}
