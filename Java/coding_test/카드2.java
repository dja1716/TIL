package coding_test;
import java.util.*;
import java.io.*;

public class 카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> deck = new LinkedList();

        int maxN = sc.nextInt();

        for(int i = 1; i <= maxN; i++) {
            deck.add(i);
        }

        while(maxN != 1) {
            // till one card left;
            deck.poll();
            maxN--;
            deck.add(deck.poll());
        }

        // print
        System.out.println(deck.peek());

        sc.close();
    }
}
