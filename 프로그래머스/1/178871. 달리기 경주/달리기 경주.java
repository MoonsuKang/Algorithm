import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();
        
        for(int i=0; i < players.length; i++){
            playerMap.put(players[i], i); // 인덱스가 키 벨류가 이름
        }
        
        // 추월 처리
        for(String calling: callings) {
            //추월한 선수 순위
            int currentIndex = playerMap.get(calling);
            // 자기 앞에 선수를 추월
            int prevIndex = currentIndex - 1;
            
            String prevPlayer = players[prevIndex]; // 앞에 있던 선수
            players[prevIndex] = calling; // 추월한 선수가 앞자리로
            players[currentIndex] = prevPlayer; // 앞에 있던 선수는 한 칸 뒤로
            
            // 선수 위치를 바꿔
            playerMap.put(calling, prevIndex);
            playerMap.put(prevPlayer, currentIndex);
            
        }
        
        return players;
    }
}
