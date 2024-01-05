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
