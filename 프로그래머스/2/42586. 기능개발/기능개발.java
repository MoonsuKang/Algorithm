import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // 각 작업의 남은 일수를 계산하여 큐에 추가
        for(int i = 0; i < progresses.length; i++){
            int remainingWork = 100 - progresses[i];//남은 퍼센트
            int days = (int) Math.ceil( (double)remainingWork / speeds[i]); // 걸리는 일 수
            queue.offer(days);
        }
            
            while (!queue.isEmpty()) {
                int currentDay = queue.poll(); // 첫 번째 작업이 완료되는 일수
                int count = 1; // 현재 배포할 기능 수
            
            // 현재 작업 이후의 작업들이 함께 배포될 수 있는지 확인
                while (!queue.isEmpty() && queue.peek() <= currentDay) {
                    queue.poll();
                    count++;
            }
            result.add(count);
        }
            
        return result.stream().mapToInt(i->i).toArray();
    }
}