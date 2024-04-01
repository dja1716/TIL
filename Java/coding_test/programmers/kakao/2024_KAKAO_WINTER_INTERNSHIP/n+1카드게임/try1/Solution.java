import java.util.*;

class Solution {
    static int answer = 0;
    static int N;
    static int[] scards;
    static int target;
    public int solution(int coin, int[] cards) {
        N = cards.length;
        target = N + 1;
        scards = cards;
        int dc = cards.length / 3;
        Set<Integer> deck = new HashSet<>();
        
        for(int i = 0; i < dc; i++) {
            deck.add(cards[i]);
        }
        rec(deck, coin, dc-1, 1);
        return answer;
    }
    
    public static void rec(Set<Integer> deck, int coin, int idx, int result) {
        answer = Math.max(answer, result);
        if(idx + 2 >= N) {
            return;
            
        }
        int firstCard = scards[idx+1];
        int secondCard = scards[idx+2];
        // no addition
        for(int card : deck) {
            if(deck.contains(target - card)) {
                Set<Integer> ns = new HashSet<>(deck);
                ns.remove(card);
                ns.remove(target - card);
                rec(ns, coin, idx+2, result + 1);
                if(coin > 0) {
                    Set<Integer> temp1 = new HashSet<>(ns);
                    ns.add(firstCard);
                    rec(temp1, coin-1, idx+2, result + 1);
                    Set<Integer> temp2 = new HashSet<>(ns);
                    ns.remove(firstCard);
                    ns.add(secondCard);
                    rec(temp2, coin-1, idx+2, result + 1);
                }
                if(coin > 1) {
                    ns.add(firstCard);
                    Set<Integer> temp3 = new HashSet<>(ns);
                    rec(temp3, coin-2, idx+2, result + 1);
                }
            }
        }
        if(deck.contains(target - firstCard) && coin > 0) {
            Set<Integer> ns = new HashSet<>(deck);
            ns.remove(target - firstCard);
            rec(ns, coin - 1, idx+2, result + 1);
        }
        if(deck.contains(target - secondCard) && coin > 0) {
            Set<Integer> ns = new HashSet<>(deck);
            ns.remove(target - secondCard);
            rec(ns, coin - 1, idx+2, result + 1);
        }
        if(firstCard + secondCard == target && coin > 1) {
            rec(deck, coin - 2, idx+2, result + 1);
        }
    }
}