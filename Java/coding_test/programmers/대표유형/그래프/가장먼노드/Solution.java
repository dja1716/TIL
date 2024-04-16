package Java.coding_test.programmers.대표유형.그래프.가장먼노드;
import java.util.*;

class Solution {
    class Node {
        int pos;
        int dis;
    }
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    int[] distance;
    boolean[] visited;
    int maxDistance = 0;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        distance = new int[n+1];
        visited = new boolean[n+1];
        
        for(int i = 0; i < edge.length; i++) {
            int p1 = edge[i][0];
            int p2 = edge[i][1];
            
            if(!graph.containsKey(p1)) {
                graph.put(p1, new HashSet<>());
            }
            if(!graph.containsKey(p2)) {
                graph.put(p2, new HashSet<>());
            }
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }
        BFS();
        
        for(int i = 0; i < distance.length; i++) {
            if(distance[i] == maxDistance) answer++;
        }
        return answer;
    }
    
    public void BFS() {
        visited[0] = true;
        visited[1] = true;
        
        Queue<Node> q = new LinkedList<>();
        Node start = new Node();
        start.pos = 1;
        start.dis = 0;
        q.add(start);
        while(!q.isEmpty()) {
            Node node = q.poll();
            for(int next : graph.get(node.pos)) {
                if(visited[next]) continue;
                visited[next] = true;
                Node newNode = new Node();
                newNode.pos = next;
                newNode.dis = node.dis + 1;
                q.add(newNode);
                distance[next] = newNode.dis;
                maxDistance = Math.max(distance[next], maxDistance);
            }
        }
    }
}