-- 코드를 입력하세요
SELECT FP.PRODUCT_ID, FP.PRODUCT_NAME, FP.PRODUCT_CD, FP.CATEGORY, FP.PRICE
FROM FOOD_PRODUCT FP
ORDER BY PRICE DESC
LIMIT 1;

# SELECT *
# FROM FOOD_PRODUCT
# ORDER BY PRICE DESC