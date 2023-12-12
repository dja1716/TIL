package 단어공부;

import java.util.*;

public class 단어공부 {
    static int answer = 0;
    static char answerC;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String S = sc.next().toUpperCase();
        
        int[] charCount = countChar(S);
        findMostOccured(charCount);
        
        System.out.println(answerC);
    }
    
    public static void findMostOccured(int[] charCount) {
        for(int i = 0; i < charCount.length; i++) {
            if(charCount[i] > answer) {
                answer = charCount[i];
                answerC = (char) ('A' + i);
            } else if(charCount[i] == answer) {
                answerC = '?';
            }
        }
    }
    
    public static int[] countChar(String S) {
        int[] result = new int['Z' - 'A' + 1];
        
        for(int i = 0; i < S.length(); i++) {
            result[S.charAt(i) - 'A']++;
        }
        
        return result;
    }
}
