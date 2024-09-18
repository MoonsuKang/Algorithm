import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 최소 힙을 사용하여 가장 작은 스코빌 지수 두 개를 꺼냄
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int s: scoville) {
            minHeap.offer(s);
        }
        // System.out.println(minHeap);
        int mixCount = 0;
        
         // 모든 음식의 스코빌 지수가 K 이상이 될 때까지
        while(minHeap.size() > 1 && minHeap.peek() < K) {
            int leastSpicy = minHeap.poll(); // 가장 작은 스코빌 지수
            int secondLeastSpicy = minHeap.poll(); // 두 번째로 작은 스코빌 지수
            // System.out.println(leastSpicy);
            // System.out.println(secondLeastSpicy);
            
            // 새로운 음식의 스코빌 지수
            int newScoville = leastSpicy + (secondLeastSpicy * 2);
            minHeap.offer(newScoville);
            mixCount++; // 섞는 횟수 증가
            
        }
        if (minHeap.peek() < K) {
            return -1;
        }

        
        return mixCount;
    }
}

// 섞은 음식의 스코빌 지수 = 
// 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)