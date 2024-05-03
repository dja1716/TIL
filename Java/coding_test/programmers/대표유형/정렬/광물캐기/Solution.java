package Java.coding_test.programmers.대표유형.정렬.광물캐기;

import java.util.*;

class Solution {
    
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        List<A> list = new ArrayList<>();
        int totalPicks = picks[0] + picks[1] + picks[2];
        for(int i = 0; i < minerals.length; i += 5) {
            A a = new A();
            for(int j = 0; j < 5; j++) {
                int idx = i + j;
                if(idx >= minerals.length || idx >= totalPicks * 5) break;
                
                if(minerals[idx].equals("diamond")) {
                    a.diamond++;
                } else if(minerals[idx].equals("iron")) {
                    a.iron++;
                } else {
                    a.stone++;
                }
            }
            list.add(a);
        }
        Collections.sort(list, (o1, o2) -> {
            if(o1.diamond != o2.diamond) {
                return o2.diamond - o1.diamond;
            }
            if(o1.iron != o2.iron) {
                return o2.iron - o1.iron;
            }
            return o2.stone - o1.stone;
        });
        
        for(A a : list) {
            if(picks[0] > 0) {
                picks[0]--;
                answer += a.stone + a.diamond + a.iron;
            } else if(picks[1] > 0) {
                picks[1]--;
                answer += a.diamond * 5 + a.iron + a.stone;
            } else {
                answer += a.diamond * 25 + a.iron * 5 + a.stone;
            }
        }
        
        return answer;
    }
    class A {
        int stone;
        int diamond;
        int iron;
    }
}