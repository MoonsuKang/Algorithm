-- 코드를 입력하세요
SELECT SUBSTR(PRODUCT_CODE, 1, 2) AS CATEGORY, COUNT(*) AS PRODUCT
FROM PRODUCT
GROUP BY CATEGORY
ORDER BY CATEGORY ASC;

# CATEGORY	PRODUCTS
# 상품 카테고리 코드(PRODUCT_CODE 앞 2자리) 별 상품 개수를 출력