# part 1
## Ch 01. 코딩 테스트 개요 및 문제 풀이를 위한 JavaScript 문법
### 01. 코딩 테스트 알아보기
* 보통 인터넷 서치 가능
* 코드 탬플렛 정리해두기
## 02. 문제 풀이를 위한 JavaScript 핵심 문법 알아보기
* 기본적인 입출력은
```Javascript
console.log
```
* 몫만 남기는 나누기
```Javascript
parseInt(a / b)
```
* 출력 시간 단축하기
  * 모아서 출력하기
```javascript
let answer = '';

/*
여러 출력 결과를 한 줄에 하나씩 출력할 때 매번 console.log()를 실행하지 않고, 하나의 문자열에 결과를 저장해서 한꺼번에 출력하는 것이 대게 더 빠르게 수행됩니다.
*/
for(let i = 1; i <= 100; i++) {
  answer += 1 + '\n'; //문자열로 변환하여 기록
}

console.log(answer);
```
