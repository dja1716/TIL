import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static LinkedList<Character> text = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] textString = st.nextToken().toCharArray();
        for (char c : textString) {
            text.add(c);
        }
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        ListIterator<Character> it = text.listIterator();

        while(it.hasNext()) {
            it.next();
        }

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.charAt(0) == 'P') {
                P(it, st.nextToken().charAt(0));
            } else if(command.charAt(0) == 'L') {
                L(it);
            } else if(command.charAt(0) == 'B') {
                B(it);
            } else if(command.charAt(0) == 'D') {
                D(it);
            }
        }

        for(char c : text) {
            bw.write(c);
        }

        bw.flush();
    }

    static void P(ListIterator<Character> it, char c) {
        it.add(c);
    }

    static void L(ListIterator<Character> it) {
        if(it.hasPrevious()) {
            it.previous();
        }
    }

    static void D(ListIterator<Character> it) {
        if(it.hasNext()) {
            it.next();
        }
    }

    static void B(ListIterator<Character> it) {
        if(it.hasPrevious()) {
            it.previous();
            it.remove();
        }
    }
}