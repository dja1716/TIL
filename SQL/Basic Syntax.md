
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
# UNION / UNION ALL
* UNION 및 UNION ALL은 SQL에서 사용되는 두 가지 다른 결과 집합 결합 연산자입니다. 이러한 연산자를 사용하여 두 개 이상의 SQL 쿼리의 결과를 결합할 수 있습니다.

1. UNION:
    * UNION은 중복된 행을 제거하여 결과 집합에서 고유한 행만 반환합니다.
    * UNION을 사용하면 결과 집합에서 중복된 행이 하나만 나타납니다.
    * 결과 집합의 열 수 및 데이터 형식이 일치해야 합니다.
```sql
SELECT column1, column2 FROM table1
UNION
SELECT column1, column2 FROM table2;
```
2. UNION ALL:
    * UNION ALL은 중복된 행을 제거하지 않고 모든 결과를 그대로 반환합니다.
    * UNION ALL을 사용하면 중복된 행이 모두 결과 집합에 포함됩니다.
    * 결과 집합의 열 수 및 데이터 형식이 일치해야 합니다.
```sql
SELECT column1, column2 FROM table1
UNION ALL
SELECT column1, column2 FROM table2;
```
# CASE
```sql
CASE
    WHEN 조건1 THEN 결과1
    WHEN 조건2 THEN 결과2
    ...
    ELSE 기본_결과
END
```
* 조건은 조건문 또는 변수명이 사용될 수 있다.
