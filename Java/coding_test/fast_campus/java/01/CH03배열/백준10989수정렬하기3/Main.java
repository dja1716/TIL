import java.util.*;
import java.io.*;

public class Main {
  static int[] arr = new int[10001];
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());

      for(int i = 0; i < N; i++) {
          st = new StringTokenizer(br.readLine());
          arr[Integer.parseInt(st.nextToken())]++;
      }



      for(int i = 1; i < arr.length; i++) {
          for(int j = 0; j < arr[i]; j++) {
              bw.write(i + "\n");
          }
      }
      bw.close(); // or bw.flush();
  }
}
