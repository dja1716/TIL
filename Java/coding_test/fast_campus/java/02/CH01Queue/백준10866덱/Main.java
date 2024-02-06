import java.util.*;
import java.io.*;

public class Main {


    static int N;
    static Deque<Integer> dq = new LinkedList<>();
    static List<Integer> answer = new LinkedList<>();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        while(N-- > 0) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push_back":
                    push_back(Integer.parseInt(command[1]));
                    break;
                case "push_front":
                    push_front(Integer.parseInt(command[1]));
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
                case "pop_back":
                    pop_back();
                    break;
                case "pop_front":
                    pop_front();
                    break;
            }
        }


        for(int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i) + "\n");
        }
        bw.flush();
    }

    public static void push_front(int X) {
        dq.addFirst(X);
    }

    public static void push_back(int X) {
        dq.add(X);
    }

    public static void front() {
        if(dq.isEmpty()) {
            answer.add(-1);
        } else {
            answer.add(dq.peekFirst());
        }
    }

    public static void back() {
        if(dq.isEmpty()) {
            answer.add(-1);
        } else {
            answer.add(dq.getLast());
        }
    }

    public static void pop_front() {
        if(dq.isEmpty()) {
            answer.add(-1);
        } else {
            answer.add(dq.pollFirst());
        }

    }

    public static void pop_back() {
        if(dq.isEmpty()) {
            answer.add(-1);
        } else {
            answer.add(dq.pollLast());
        }

    }

    public static void size() {
        answer.add(dq.size());
    }

    public static void empty() {
        answer.add(dq.isEmpty() ? 1 : 0);
    }
}