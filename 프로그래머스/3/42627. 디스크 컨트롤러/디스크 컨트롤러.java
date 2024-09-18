import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        // 요청 시점이 빠른 순으로 정렬
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        //소모시간 빠른 순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int currentTime = 0; // 현재 시점
        int jobIndex = 0; // jobs 배열에서 다음에 처리할 작업의 인덱스
        int totalWaitTime = 0; // 총 대기 시간
        int completedJobs = 0; // 완료된 작업 수
        int jobCount = jobs.length; // 전체 작업 수
        
        while (completedJobs < jobCount) {
                    // 현재 시점까지 도착한 모든 작업을 우선순위 큐에 추가
                    while (jobIndex < jobCount && jobs[jobIndex][0] <= currentTime) {
                        pq.offer(jobs[jobIndex]);
                        jobIndex++;
                    }

                    if (pq.isEmpty()) {
                        // 현재 처리할 작업이 없으면 다음 작업의 요청 시점으로 이동
                        currentTime = jobs[jobIndex][0];
                    } else {
                        // 현재 시점에 처리할 수 있는 작업 중 가장 소요 시간이 짧은 작업 처리
                        int[] currentJob = pq.poll();
                        currentTime += currentJob[1];
                        totalWaitTime += currentTime - currentJob[0]; // 현재 시점 - 작업 요청 시점 = 작업 대기 시간
                        completedJobs++;
                    }
                }

        return totalWaitTime / jobCount;
    }
}