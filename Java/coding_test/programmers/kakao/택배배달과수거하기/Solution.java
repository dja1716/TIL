class Solution {
    // 이동거리 최소화
    static int pLast;
    static int dLast;
    static long answer = 0;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        pLast = n - 1;
        dLast = n - 1;
        while(pLast >= 0) {
            if(pickups[pLast] > 0) {
                break;
            }
            pLast--;
        }
        
        while(dLast >= 0) {
            if(deliveries[dLast] > 0) {
                break;
            }
            dLast--;
        }
        
        while(pLast >= 0 || dLast >= 0) {
            int pIdx = pLast;
            int dIdx = dLast;
            while(pIdx >= 0) {
                if(pickups[pIdx] > 0) {
                    break;
                }
                pIdx--;
            }
            while(dIdx >= 0) {
                if(deliveries[dIdx] > 0) {
                    break;
                }
                dIdx--;
            }
            answer += ((long) Math.max(pIdx, dIdx) + 1L) * 2L;
            int pCount = cap;
            int dCount = cap;
            while(pIdx >= 0 && pCount > 0) {
                if(pickups[pIdx] > 0) {
                    if(pCount <= pickups[pIdx]) {
                        pickups[pIdx] -= pCount;
                        if(pickups[pIdx] == 0) {
                            pIdx--;
                        }
                        break;
                    } else {
                        pCount -= pickups[pIdx];
                        pickups[pIdx] = 0;
                    }
                }
                pIdx--;
            }
            while(dIdx >= 0 && dCount > 0) {
                if(deliveries[dIdx] > 0) {
                    if(dCount <= deliveries[dIdx]) {
                        deliveries[dIdx] -= dCount;
                        if(deliveries[dIdx] == 0) {
                            dIdx--;
                        }
                        break;
                    } else {
                        dCount -= deliveries[dIdx];
                        deliveries[dIdx] = 0;
                    }
                }
                dIdx--;
            }
            pLast = pIdx;
            dLast = dIdx;
        }
        return answer;
    }
    
    
}