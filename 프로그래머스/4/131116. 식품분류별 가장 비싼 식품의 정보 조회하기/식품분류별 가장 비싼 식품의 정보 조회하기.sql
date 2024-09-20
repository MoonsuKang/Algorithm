WITH MaxPriceProduct AS (
    SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME,
           ROW_NUMBER() OVER (PARTITION BY CATEGORY ORDER BY PRICE DESC) AS rn
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
)
SELECT CATEGORY, MAX_PRICE, PRODUCT_NAME
FROM MaxPriceProduct
WHERE rn = 1
ORDER BY MAX_PRICE DESC;


#ROW_NUMBER() 함수는 각 CATEGORY별로 가격을 내림차순으로 정렬하여 각 그룹의 첫 번째 항목을 rn = 1로 표시합니다. 즉, 분류별로 가장 비싼 식품에 rn = 1이 할당됩니다
