-- 코드를 입력하세요
SELECT AO.ANIMAL_ID, AO.NAME
FROM ANIMAL_OUTS AO
LEFT JOIN ANIMAL_INS AI ON AO.ANIMAL_ID = AI.ANIMAL_ID
WHERE AI.ANIMAL_ID IS NULL;


#ANIMAL_ID	NAME
#입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회
#ANIMAL_OUTS 테이블을 기준으로 ANIMAL_INS 테이블과 ANIMAL_ID를 기준으로 LEFT JOIN합니다.
#이렇게 하면 ANIMAL_OUTS의 모든 레코드에 대해 ANIMAL_INS 테이블의 매칭되는 레코드가 있으면 연결되고, 없으면 NULL로 표시됩니다.