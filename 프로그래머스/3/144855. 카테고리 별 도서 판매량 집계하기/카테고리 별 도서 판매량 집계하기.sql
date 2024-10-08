-- 코드를 입력하세요
SELECT B.CATEGORY, SUM(BS.SALES) AS TOTAL_SALES
FROM BOOK B
JOIN BOOK_SALES BS ON B.BOOK_ID = BS.BOOK_ID
WHERE DATE_FORMAT(BS.SALES_DATE,'%Y-%m') = '2022-01'
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY ASC;


#2022년 1월의 카테고리 별 도서 판매량을 합산하고,
#카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력