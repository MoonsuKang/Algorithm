import java.util.* ;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int totalWeightOnBridge = 0; // 다리 위 트럭 총 무게
        int time = 0; // 경과 시간
        int truckIndex = 0; // 다리를 건너려고 하는 트럭 인덱스 값
        
        // 다리 길이만큼 0으로 채워 (트럭이 다리를 건너지 않는 상태)
        for(int i = 0; i < bridge_length; i++){
            queue.offer(0);
        }
        
        while(truckIndex < truck_weights.length) {
            // 시간 경과
            time++;
            totalWeightOnBridge -= queue.poll(); // 맨 앞을 내려
            
            // 현재 다리에 올라갈 수 있는 트럭이 있는지 확인
            if(totalWeightOnBridge + truck_weights[truckIndex] <= weight) {
                queue.offer(truck_weights[truckIndex]);
                totalWeightOnBridge += truck_weights[truckIndex];
                truckIndex++;
            } else {
                // 다리의 무게를 초과하는 경우, 기존 트럭들만 이동
                queue.offer(0);
            }
            
        }
        // 마지막 트럭이 다리를 건너는 데 걸리는 시간
        time += bridge_length;
        
        
        return time;
    }
}