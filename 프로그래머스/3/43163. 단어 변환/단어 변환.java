import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 단어 집합에 target이 없는 경우 바로 0 반환
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(begin, 0)); // 시작 단어와 변환 단계 0을 큐에 추가
        boolean[] visited = new boolean[words.length];
        
        while (!queue.isEmpty()) {
            WordNode current = queue.poll();
            String currentWord = current.word;
            int currentSteps = current.steps;

            if (currentWord.equals(target)) {
                return currentSteps;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canTransform(currentWord, words[i])) {
                    visited[i] = true; // 방문 처리
                    queue.add(new WordNode(words[i], currentSteps + 1)); // 변환 단계 증가
                }
            }
        }

        // 변환할 수 없는 경우 0 반환
        return 0;
    }
    
    // 두 단어가 한 글자만 다른지 확인
     private boolean canTransform(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        return diffCount == 1;
    } 
    
    private class WordNode {
        String word;
        int steps;
        
        WordNode(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
}