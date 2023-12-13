
# SELECT
* ```ORDER BY```에서 ","를 통해 컬럼들 구분
* ```GROUP BY``` ```HAVING```
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
