N = int(input()) #카드 갯수
cards = set(map(int, input().split()))
M = int(input()) #주어진 수의 갯수
cards_check = list(map(int, input().split())) # 검사할 숫자 리스트
result = [1 if number in cards else 0 for number in cards_check]
print(" ".join(map(str, result)))