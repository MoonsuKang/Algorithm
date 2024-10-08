SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d'), PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM (
    -- 온라인 판매 데이터
    SELECT SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
    FROM ONLINE_SALE
    WHERE SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'

    UNION ALL

    -- 오프라인 판매 데이터
    SELECT SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
    FROM OFFLINE_SALE
    WHERE SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'
) AS ALL_SALES
ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID ASC;

#온라인
#상품 판매 ID, 회원 ID, 상품 ID, 판매량, 판매일

#오프라인
#상품 판매 ID, 상품 ID, 판매량, 판매일

# 2022년 3월의 오프라인/온라인 상품 판매 데이터의 판매 날짜, 상품ID, 유저ID, 판매량을 출력
