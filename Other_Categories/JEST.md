- 스터디 출처: https://inpa.tistory.com/category/Testing/JEST

## Jest 기본 문법
- jest는 test runner, test matcher, test mock 프레임워크를 제공한다
- 파일명은 xxx.test.ts 또는 xxx.spec.ts (또는 js)로 한다
- describe는 테스트 그룹을 묶어주는 역할을 하고, 그 안의 콜백함수 내에 테스트에 쓰일 가자 변수, 객체를 선언하여 일회용으로 사용할 수 있다.
- toXxx 는 TestMatcher이다

## Jest Matcher
- matcher란 기대한 값과 실제 반환된 값이 일치하는 지를 확인하는 작업이다.
- toEqual() : 객체 일치 검증
- toBe() : primitive value 비교
- toBeDefined() : 변수가 정의되었는지 여부
- toBeTruthy() / toBeFalsy() : 검증대상이 true/false로 간주되는지 확인
- toBeCalled() / toHaveBeenCalled() : 함수가 호출되었는지 여부. 둘이 같은 역할을 하는 함수이다
- toHaveLength() : 배열의 길이 체크
- toContain() : 특정 원소가 배열에 들어가는지
- toMatch() : string이 정규식 기반으로 일치하는지 비교
- toThrow(msg?: string | regex) : 예외 발생 여부 테스트
  - 문자열을 넘기면 예외 메세지와 비교
  - 정규식을 넘기면 정규식 체크
- toHaveProperty() : 객체에 해당하는 key-value 값이 있는지 검사한다
- toBeCalledTimes() : 함수가 몇번 호출되었는지 검증
- toBeCalledWith() : 함수가 설정한 인자로 호출되었는지 검증
- toReturn() / toHaveReturned() 함수가 오류없이 반환되었는지 테스트
- toReturnTimes() / toHaveReturnedTimes() : 함수가 지정한 횟수만큼 오류없이 반환되었는지 테스트
- toReturnWith() / toHaveReturnedWith(value) : 함수가 지정한 값을 반환하는지 테스트

## 비동기 코드 테스트 방법
- 콜백
```javascript
test("fetch a user", (done) => { // 콜백 인자에 done을 써서 비동기 함수 테스트임을 반드시 명시 !!
  const cb = (user) => {
    // 인자로 받은 리턴값 user객체가 해당 객체와 Equal일 경우 테스트
    expect(user).toEqual({ 
      id: 1,
      name: "User1",
      email: "1@test.com",
    });
    
    done(); // 비동기 실행 end
  }
  
  fetchUser(1, cb);
});
```
- Promise
```javascript
test("fetch a user", () => {
  // Promise 객체 함수에 return을 써서, Jest Runner가 Promise가 resolve될때까지 기다려 주게 한다.
  return fetchUser(1) 
  	.then((user) => {
        expect(user).toEqual({
          id: 1,
          name: "User1",
          email: "1@test.com",
    	});
  	});
});
```
- async/await
```javascript
test("fetch a user", async () => {
  const user = await fetchUser(1);
  
  expect(user).toEqual({
    id: 1,
    name: "User1",
    email: "1@test.com",
  });
});
```
## Mocking
- mocking이란 테스트하고자 하는 코드가 의존하는 function이나 class에 대해 모조품을 만들어 테스팅하는 것
- 단위 테스트를 작성할 때, 해당 코드가 의존하는 부분을 가짜(mock)로 대체하는 기법
### jest.fn
- 가짜 함수 (mock function) 생성
- mockReturnValue(value) : 반환값을 지정해준다
```javascript
const mock = jest.fn();

mock.mockReturnValue(42);
mock(); // 42

mock.mockReturnValue(63);
mock(); // 63
```
- mockImplementation(value) : mock 함수를 즉석으로 구현할 수 있다
```javascript
const mockFn = jest.fn();

// 동작하는 모크 함수를 하나 만든다.
mockFn.mockImplementation( (name) => `I am ${name}!` ); 

console.log(mockFn("Dale")); // I am Dale!
```
```javascript
// 단축 속성으로 아예 jest.fn() 안에다가 바로 함수를 써서도 똑같이 구현할 수 있다.
// 이 방법이 더 간편하고 직관적이기에 자주 사용하는 편이다.
const mockFn = jest.fn( (name) => `I am ${name}!` );

console.log(mockFn("Dale")); // I am Dale!
```
- mockResolvedValue(value) / mockRejectValue(value) : 비동기 함수에서 resolve / reject 값을 받는다
### jest.mock
- jest.fn() : 개별적으로 하나씩 모킹 처리해줄 떄 사용
- jest.mock() : 그룹을 한꺼번에 모킹 처리해줄 때 사용
```javascript
jest.mock('../models/user'); // ../models/user.js에서 export한 객체와 모든 내부요소들을 그룹 모킹화 한다.
const User = require('../models/user'); // 이제 앞으로 ../models/user.js에서 꺼내 쓰는 요소들은 모두 모킹화 된 것들이다.

User.findOrCreate().mockReturnValue() // jest.fn() 처리 없이 자동으로 모킹화 되어있어 바로 사용하면 된다.
```
### jest.spyOn
- 어떤 객체에 속한 함수의 구현을 가짜로 대체하지 않고, 해당 함수의 호출 여부와 어떻게 호출되었는지만 알아내야 할때
### before() / after()
- before / after 이라는 말은, 테스트 하기 전 / 한 후에 데이터 설정 혹은 정리를 위해 쓰인다
### beforeAll() / afterAll()
- 맨 처음과 맨 끝에 한번씩만 호출
```javascript
let connection;

// 테스트 실행하기전에 미리 전역 설정
beforeAll(() => {
  conection = openConnection({ host: "...", port: "..." });
});


... 여러개의 test 코드들
... 여러 테스트 함수 내에서 connection 객체를 많이 사용한다.


// 테스트 완료후 해체
afterAll(() => {
  conection.close();
});
```
### beforeEach() / afterEach()
- beforeAll() : 전역으로 초기에 한번 호출되는 것
- beforeEach() : 여러 테스트 함수들이 각각 실행될 떄마다 매번 불러와는 것 
