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
* 코딩 테스트용 JavaScript 기본 입력 - fs 모듈
  * 기능: 전체 텍스트를 읽어 온 뒤에, 줄바꿈 기호를 기준으로 구분하여 리스트로 변경하기
```javascript
// readline 모듈보다는 fs를 이용해 파일 전체를 읽어 들려 처리하기
let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().split('\n');

console.log(input);
```
* 만일 fs 모듈을 사용할 수 없는 경우
  * readline 모듈을 사용하여 한 줄씩 입력을 받아서, 처리하여 정답을 출력할 수 있다.
```javascript
const rl = require('readline').createInterface({
 input: process.stdin,
 output: process.stdout
});

let input = [];
rl.on('line', function(line) {
 // 콘솔 입력 창에서 줄바꿈(Enter)를 입력할 때마다 호출
 input.push(line);
}).on('close', function() {
 // 콘솔 입력 창에서 ctrl + C 혹은 Ctrl + D를 입력하면 호출 (입력의 종료)
 console.log(input);
 process.exit();
});
```
* Number와 String 형태 변환
```javascript
/*
Int -> String
*/
let a = "777";
let b = Number(a);
console.log(b); // 777

/*
String -> Int
*/
let a = 777;
let b = String(a);
console.log(b); // "777"
```
* 배열의 모든 원소에 대해 특정한 연산을 순차적으로 적용할 때 reduce()를 사용한다
  * Array.prototype.reduce()
```javascript
/*
reduce() 매서드는 배열의 각 요소에 대해 reducer 함수를 실행한 뒤에 하나의 결과를 반환합니다.
reducer의 형태: (accumulator, currentValue) => (반환값)
- 배열의 각 원소를 하나씩 확인하며, 각 원소는 currentValue에 해당합니다.
- 변환값은 그 이후의 원소에 대하여 accumulator에 저장됩니다.
*/
let data = [5, 2, 9, 8, 4];

// minValue 구하기 예제
let minValue = data.reduce((a, b) => Math.min(a, b));
console.log(minValue); // 2

// 원소의 합계 구하기 예제
let summary = data.reduce((a, b) => a + b);
console.log(summary); // 28
```
* 배열 초기화 방법
  * 알고리즘 문제를 풀 때 자주 사용되는 배열 초기화 방식은 다음과 같다.
```javascript
// 직접 값을 설정하여 초기화
let arr = [8, 1, 4, 5, 7];

// 길이가 5이고 모든 원소의 값이 0인 배열 초기화
let arr = new Array(5).fill(0);
```

* Set
```javascript
let mySet = new Set(); // 집합 객체 생성

// 여러 개의 원소 삽입
mySet.add(3);
mySet.add(5);
mySet.add(7);
mySet.add(3);

console.log(`원소의 개수: ${mySet.size}`);
console.log(`원소 7을 포함하고 있는가? ${mySet.has(7)}`);

// 원소 5 제거
mySet.delete(5);

// 원소를 하나씩 출력
for (let item of mySet) console.log(item);
