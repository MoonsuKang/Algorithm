-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME,'%Y-%m-%d') AS '날짜'
FROM ANIMAL_INS;

# 모든 레코드에 대해, 각 동물의 아이디와 이름, 들어온 날짜1를 조회
# ANIMAL_ID	 NAME	날짜
