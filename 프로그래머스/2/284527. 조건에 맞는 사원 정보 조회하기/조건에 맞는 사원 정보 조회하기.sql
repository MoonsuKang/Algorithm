WITH TOTAL_SCORES AS (
    SELECT G.EMP_NO, SUM(G.SCORE) AS SCORE
    FROM HR_GRADE G
    WHERE G.YEAR = 2022
    GROUP BY G.EMP_NO
)
SELECT T.SCORE, E.EMP_NO, E.EMP_NAME, E.POSITION, E.EMAIL
FROM TOTAL_SCORES T
JOIN HR_EMPLOYEES E ON T.EMP_NO = E.EMP_NO
WHERE T.SCORE = (SELECT MAX(SCORE) FROM TOTAL_SCORES)
ORDER BY E.EMP_NO;


# #HR_DEPARTMENT, HR_EMPLOYEES, HR_GRADE 테이블에서 
# #2022년도 한해 평가 점수가 가장 높은 사원 정보를 조회