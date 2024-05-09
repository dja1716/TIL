-- 코드를 입력하세요
SELECT DATE_FORMAT(T1.SALES_DATE, "%Y-%m-%d") AS SALES_DATE, T1.PRODUCT_ID, T1.USER_ID, T1.SALES_AMOUNT
FROM ONLINE_SALE T1
WHERE T1.SALES_DATE >= "2022-03-01"
AND T1.SALES_DATE < "2022-04-01"

UNION ALL

SELECT DATE_FORMAT(T2.SALES_DATE, "%Y-%m-%d") AS SALES_DATE, T2.PRODUCT_ID, NULL AS USER_ID, T2.SALES_AMOUNT
FROM OFFLINE_SALE T2
WHERE T2.SALES_DATE >= "2022-03-01"
AND T2.SALES_DATE < "2022-04-01"

ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID ASC