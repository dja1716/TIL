import java.util.*;

class Solution {
    static Set<Integer> have = new HashSet<>();
    static Set<Integer> notHave = new HashSet<>();
    static int nPlus1;
    static int[] cards;
    static int N;
    static int answer = 0;
    
    public int solution(int coin, int[] c) {
        cards = c;
        N = c.length;
        nPlus1 = N + 1;
        int idx = N / 3;
        
        for(int i = 0; i < idx; i++) {
            have.add(cards[i]);
        }
        helper(idx-1, coin, 1);
        return answer;
    }
    
    public static void helper(int idx, int coin, int round) {
        answer = Math.max(answer, round);
        if(idx + 2 > N) {
            return;
        }
        int firstCard = cards[idx + 1];
        int secondCard = cards[idx + 2];
        notHave.add(firstCard);
        notHave.add(secondCard);
        idx += 2;
        for(int card: have) {
            if(have.contains(nPlus1 - card)) {
                have.remove(card);
                have.remove(nPlus1 - card);
                helper(idx, coin, round + 1);
                return;
            }
        }
        if(coin > 0) {
            for(int card: have) {
                if(notHave.contains(nPlus1 - card)) {
                    have.remove(card);
                    notHave.remove(nPlus1 - card);
                    helper(idx, coin - 1, round + 1);
                    return;
                }
            }
        }
        if(coin > 1) {
            for(int card: notHave) {
                if(notHave.contains(nPlus1 - card)) {
                    notHave.remove(card);
                    notHave.remove(nPlus1 - card);
                    helper(idx, coin - 2, round + 1);
                    return;
                }
            }
        }
        
    }
}