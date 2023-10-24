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
