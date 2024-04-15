package Java.coding_test.programmers.대표유형.힙.디스크컨트롤러;
import java.util.*;

class Solution {
    
    static class Job {
        int arrivedAt;
        int duration;
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int curTime = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2)-> {
            return j1.duration - j2.duration;
        });
        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        int idx = 0;
        
        while(idx < jobs.length) {
            Job nj;
            if(pq.isEmpty()) {
                nj = new Job();
                nj.duration = jobs[idx][1];
                nj.arrivedAt = jobs[idx][0];
                pq.add(nj);
                idx++;
                curTime = curTime > nj.arrivedAt ? curTime : nj.arrivedAt;
            }
            
            nj = pq.poll();
            
            
            curTime = curTime > nj.arrivedAt ? curTime : nj.arrivedAt;
            curTime += nj.duration;
            answer += curTime - nj.arrivedAt;
            while(idx < jobs.length) {
                if(jobs[idx][0] <= curTime) {
                    Job nj2 = new Job();
                    nj2.duration = jobs[idx][1];
                    nj2.arrivedAt = jobs[idx][0];
                    idx++;
                    pq.add(nj2);
                } else {
                    break;
                }
            }
            
        }
        while(!pq.isEmpty()) {
            Job pj = pq.poll();
            curTime += pj.duration;
            answer += curTime - pj.arrivedAt;
        }
        return answer / jobs.length;
    }
}