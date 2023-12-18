import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());
        int[] arrT = new int[T];
        int[] ans = new int[T];

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            arrT[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < T; i++) {
            for(int j = 2; j <= 64; j++) {
                String temp = "";
                int temp3 = arrT[i];
                while(temp3 > 0) {
                    int tempInt = temp3 % j;
                    temp3 /= j;
                    temp = tempInt + " " + temp;
                }
                String[] temp2 = temp.split(" ");
                int until = temp2.length / 2;
                int result = 1;
                for(int k = 0; k < until ; k++) {
                    if(!temp2[k].equals(temp2[temp2.length - 1 - k])) {
                        result = 0;
                        break;
                    }
                }
                if(result == 1) {
                    ans[i] = 1;
                    break;
                }
            }
        }
        for(int i = 0; i < T; i++) {
            bw.write(ans[i] + "\n");
        }
        
        bw.flush();
    }
}
