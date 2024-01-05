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
