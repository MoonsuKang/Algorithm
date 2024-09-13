SELECT MCDP_CD AS "진료과코드", COUNT(DISTINCT PT_NO) AS "5월예약건수"
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, '%Y-%m') = '2022-05'
GROUP BY MCDP_CD
ORDER BY COUNT(DISTINCT PT_NO) ASC, MCDP_CD ASC;

# SELECT * FROM APPOINTMENT;



#2022년 5월에 예약한 환자 수를 진료과코드 별로 조회
#컬럼명은 '진료과 코드', '5월예약건수'로 지정