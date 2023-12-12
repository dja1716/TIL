package coding_test.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미10158 {
  static int t, w, h, p, q;
  static BufferedReader bf;
  static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    bf = new BufferedReader(new InputStreamReader(System.in));

    getInput();
    process();
  }

  public static void process() {
    int x = (p + t) % (2 * w);
    int y = (q + t) % (2 * h);

    if(x > w) {
      x = 2 * w - x;
    }

    if(y > h) {
      y = 2 * h - y;
    }

    System.out.println(x + " " + y);
  }

  public static void getInput() throws IOException{
    st = new StringTokenizer(bf.readLine());
    
    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(bf.readLine());
    p = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(bf.readLine());
    t = Integer.parseInt(st.nextToken());
  }
}
