-- 코드를 입력하세요
SELECT 
    CAR_ID,
    CASE 
        WHEN SUM(CASE WHEN START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16' THEN 1 ELSE 0 END) > 0 THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY 
    CAR_ID
ORDER BY 
    CAR_ID DESC;


# 2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시
# 대여 중이지 않은 자동차인 경우 '대여 가능'을 표시하는 컬럼(컬럼명: AVAILABILITY)을 추가
# 자동차 ID와 AVAILABILITY 리스트를 출력