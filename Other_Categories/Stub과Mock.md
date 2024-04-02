### REFERENCE
* https://azderica.github.io/00-test-mock-and-stub/
* https://velog.io/@goseungwon/Test-Stub%EA%B3%BC-Mock%EC%9D%98-%EC%B0%A8%EC%9D%B4%EC%A0%90

## 테스트 대역 (Test Double)이란
* 테스트 대역이란 테스트하려는 객체가 다른 객체들이 여러 관계가 엮여있어 사용하기 힘들 때, 대체할 수 있는 객체를 의미합니다.

## 테스트 더블 종류들
* Dummy: 객체는 전달되지만 사용되지 않고 일반적으로 매개변수 목록을 채우는 목적으로만 사용됩니다.
* Fake: 객체는 실제로 작동하는 구현을 가지고 있지만 일반적으로 프로덕션에 적합하지 않는 몇 가지 지름길을 사용합니다.
  * ex, in memorry database
* Stub: 테스트 중에 만들어진 호출에 미리 준비된 답변을 제공하며 일반적으로 테스트를 위해 프로그래밍 된 것 외에는 전혀 응답하지 않습니다.
* Spy: 어떻게 호출 받았는지에 따라 일부 정보를 기록하는 Stub
* Mock: 예상되는 기대값으로 미리 프로그래밍된 객체

1. **Dummy (더미)**:
   Nest.js에서 더미 객체를 만드는 것은 Jest에서 직접적으로 관여되는 것보다는 일반적인 TypeScript 또는 JavaScript 개발 패턴에 더 가깝습니다. 예를 들어, 특정 인터페이스를 구현하지 않고 단순히 인터페이스의 형태를 따르는 빈 클래스를 만들 수 있습니다.

   ```typescript
   // 더미 객체 예제
   class DummyService implements SomeInterface {
       // 빈 구현
   }
   ```

2. **Stub (스텁)**:
   Jest를 사용하여 메서드의 반환 값을 정의하는 데 스텁을 사용할 수 있습니다. 특히 모의 함수(Mock Functions)를 사용하여 메서드를 대체하고 원하는 반환 값을 정의할 수 있습니다.

   ```typescript
   // 스텁 예제
   jest.spyOn(service, 'getData').mockReturnValue(someData);
   ```

3. **Spy (스파이)**:
   Jest에서 스파이를 만들려면 `jest.spyOn`을 사용하여 객체의 메서드를 감시하고 호출된 횟수를 확인할 수 있습니다.

   ```typescript
   // 스파이 예제
   const spy = jest.spyOn(service, 'getData');
   // 특정 동작 실행
   expect(spy).toHaveBeenCalled();
   ```

4. **Mock (모의객체)**:
   Jest에서 모의 객체를 생성할 때는 `jest.mock()`을 사용하여 외부 종속성을 대체하고, 이를 통해 특정 동작이 실행되었는지 검증할 수 있습니다.

   ```typescript
   // 모의객체 예제
   jest.mock('./dependency', () => ({
       DependencyClass: jest.fn(() => ({
           someMethod: jest.fn(),
       })),
   }));
   ```

5. **Fake (페이크)**:
   Nest.js에서 페이크를 구현할 때는 일반적으로 실제 구현을 대체하는 데 필요한 커스텀 클래스나 모듈을 작성하여 사용합니다. 이것은 Nest.js의 의존성 주입(Dependency Injection) 패턴과 잘 어울립니다.

   ```typescript
   // 페이크 객체 예제
   @Injectable()
   export class FakeService {
       getData(): string {
           return 'Fake Data';
       }
   }
   ```

위 예제에서 볼 수 있듯이, Nest.js와 Jest를 함께 사용하여 Test Double을 구현하는 것은 TypeScript 및 JavaScript의 기본 개념과 Jest의 특성에 의존합니다. Jest는 스파이, 스텁, 모의 객체 등을 제공하며, Nest.js는 이러한 기능을 활용하여 테스트 가능한 코드를 작성하고 테스트를 수행하는 데 사용됩니다.

### Mock과 Stub 차이점 요약
![스크린샷 2024-04-02 오후 4 28 54](https://github.com/dja1716/TIL/assets/20631646/6e91f3ca-df92-4f63-b691-e4daafa49e0d)
