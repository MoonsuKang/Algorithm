#그래프에 정보를 넣고
#방문 기록지인 visited를 초기화
#1번 노드부터 차례대로 훑으면서 처음방문했을때 DFS를 통해연결되어있는 노드를 확인하며 방문지를 업데이트
#cnt+=1로 업데이트

# 컴퓨터의 수와 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수 입력
n = int(input())
m = int(input())

# 네트워크 연결 정보를 저장할 리스트 생성
network = [[] for _ in range(n + 1)]

# 네트워크 연결 정보 입력받기
for _ in range(m):
    u, v = map(int, input().split())
    network[u].append(v)
    network[v].append(u)

# DFS로 웜 바이러스 퍼뜨리기
def DFS(v):
    visited[v] = True
    for e in network[v]:
        if not visited[e]:
            DFS(e)

# 방문 여부를 저장할 리스트 초기화
visited = [False] * (n + 1)

# 1번 컴퓨터에서 시작하여 웜 바이러스 퍼뜨리기
DFS(1)

# visited 리스트에서 1번 컴퓨터를 제외하고 True로 표시된 개수를 세어 출력
count = sum(visited) - 1
print(count)
