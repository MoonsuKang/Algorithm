-- 코드를 작성해주세요
SELECT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS D
JOIN SKILLCODES S1 ON S1.NAME = 'Python'
JOIN SKILLCODES S2 ON S2.NAME = 'C#'
WHERE (D.SKILL_CODE & S1.CODE) > 0
   OR (D.SKILL_CODE & S2.CODE) > 0
ORDER BY D.ID ASC;
#스킬의 이름, 스킬의 범주, 스킬의 코드를 의미합니다. 스킬의 코드
#개발자의 ID, 이름, 성, 이메일, 스킬 코드
#개발자의 ID, 이메일, 이름, 성을 조회