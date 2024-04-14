package Java.coding_test.programmers.대표유형.해시.배스트앨범;

import java.util.*;
import java.io.*;

class Solution {
    static Map<String, Integer> genreToPlay = new HashMap<>();
    static Map<String, Set<Integer>> genreToIdx = new HashMap<>();
    
    
    public int[] solution(String[] genres, int[] plays) {
        
        for(int i = 0; i < genres.length; i++) {
            genreToPlay.put(genres[i], genreToPlay.getOrDefault(genres[i], 0) + plays[i]);
            if(!genreToIdx.containsKey(genres[i])) {
                genreToIdx.put(genres[i], new HashSet<>());
            }
            genreToIdx.get(genres[i]).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        String[] genreArr = new String[genreToPlay.size()];
        int idx = 0;
        for(String genre : genreToPlay.keySet()) {
            genreArr[idx++] = genre;
        }
        Arrays.sort(genreArr, (a, b) -> {
            return genreToPlay.get(b) - genreToPlay.get(a);
        });
        for(int i = 0; i < genreArr.length; i++) {
            int firstSong = -1;
            int secondSong = -1;
            int firstN = -1;
            int secondN = -1;
            Iterator<Integer> it = genreToIdx.get(genreArr[i]).iterator();
            
            while(it.hasNext()) {
                int songIdx = it.next();
                if(firstSong == -1) {
                    firstSong = songIdx;
                    firstN = plays[songIdx];
                } else if(firstN < plays[songIdx] || (firstN == plays[songIdx] && firstSong > songIdx)) {
                    secondSong = firstSong;
                    secondN = firstN;
                    
                    firstSong = songIdx;
                    firstN = plays[songIdx];
                } else if(secondN == -1) {
                    secondSong = songIdx;
                    secondN = plays[songIdx];
                } else if(secondN < plays[songIdx] || (secondN == plays[songIdx] && secondSong > songIdx)) {
                    secondSong = songIdx;
                    secondN = plays[songIdx];
                }
            }
            if(firstSong != -1) {
                ans.add(firstSong);
            }
            if(secondSong != -1) {
                ans.add(secondSong);
            }
        }
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}