SELECT GU.USER_ID, GU.NICKNAME, SUM(GB.PRICE) as TOTAL_SALES
FROM USED_GOODS_BOARD GB
JOIN USED_GOODS_USER GU
ON GB.WRITER_ID = GU.USER_ID
WHERE GB.STATUS = 'DONE'
GROUP BY GU.USER_ID, GU.NICKNAME
HAVING SUM(GB.PRICE) >= 700000
ORDER BY TOTAL_SALES ASC;

#완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회
#USER_ID	NICKNAME	TOTAL_SALES