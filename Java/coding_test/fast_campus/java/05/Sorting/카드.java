import java.util.*;

public class 카드 {
    static long value = 0;
    static long count = 0;
    static int N;
    static HashMap<Long, Integer> map = new HashMap();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        for(int i = 0; i < N; i++) {
            long temp = sc.nextLong();
            
            if(map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        
        for(Map.Entry<Long, Integer> member : map.entrySet()) {
            if(member.getValue() > count) {
                value = member.getKey();
                count = member.getValue();
            }
            if(member.getValue() == count) {
                if(member.getKey() < value) {
                    value = member.getKey();
                }
            }
        }
        
        System.out.println(value);
    }
}
