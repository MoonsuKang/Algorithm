-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty');

# ANIMAL_ID	  NAME	SEX_UPON_INTAKE
# Lucy, Ella, Pickle, Rogan, Sabrina, Mitty인 동물의 
# 아이디와 이름, 성별 및 중성화 여부를 조회