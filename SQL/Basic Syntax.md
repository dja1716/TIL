
# SELECT
* ```ORDER BY```에서 ","를 통해 컬럼들 구분
* ```GROUP BY``` ```HAVING```란
     * 출처: ChatGPT
     * GROUP BY:
The GROUP BY clause is used to group rows from a database table based on the values in one or more columns. When you use GROUP BY, it creates a group for each unique combination of values in the specified columns. You can then apply aggregate functions, such as SUM, COUNT, AVG, MAX, or MIN, to each group to calculate summary statistics for the grouped data.
     * HAVING:
The HAVING clause is used to filter the results of a GROUP BY query. It allows you to specify conditions that must be met by the aggregated data after grouping has been applied. HAVING is similar to the WHERE clause, but it operates on aggregated data rather than individual rows.
* SELCT (BASIC)
```sql
SELECT 컬럼1, 컬럼2, ...
FROM 테이블명
WHERE 조건들
ORDER BY 컬럼명들
```

* GROUP BY ~ HAVING (BASIC)
* 예시 출처: https://gent.tistory.com/366
```sql
SELECT job
     , deptno
     , COUNT(*) cnt
  FROM emp
 WHERE deptno IN ('10', '20', '30')
 GROUP BY job, deptno
HAVING deptno = '20'
```
# UPDATE
```sql
UPDATE 테이블명
SET 컬럼1=value1, 컬럼2=value2, ...
WHERE condition(조건)
```
