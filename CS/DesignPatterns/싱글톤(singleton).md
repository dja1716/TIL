* 아래 링크의 책에서 내용을 발췌했습니다.
* https://ebook-product.kyobobook.co.kr/dig/epd/ebook/E000002950899
# 싱글톤 패턴 개요
- 하나의 클래스에 오직 하나의 인스턴스만 가지는 패턴
- 보통 하나의 클래스를 기반으로 여러 개의 개별적인 인스턴스를 만들 수 있지만, 그렇게 하지 않고 하나의 클래스를 기반으로 하나의 인스턴스를 만들어 이를 기반으로 로직을 만드는데 쓰인다.
- 보통 **데이터베이스 연결 모듈**에 많이 사용된다.
- 장점: 하나의 인스턴스를 만들어 놓고 해당 인스턴스를 다른 모듀들이 공유하며 사용하기 때문에 인스턴스를 생성할 때 드는 비용이 줄어든다.
- 단점: 의존성이 높아진다
- 자바스크립트에서는 리터럴 {} 또는 new Object로 객체를 생성하게 되면 어떤 객체와도 같지 않기 때문에 이 자체만으로 싱글톤 패턴을 구현할 수 있다.

### 자바스크립트 예시
```javascript
class Singleeton {
  constructor() {
    if(!Singleton.instance) {
      Singleton.instance = this;
    }
  }
  getInstance() {
    return this;
  }
}

const a = new Singleton();
const b = new Singleton();
console.log(a === b) // true
```

### 자바스크립트 DB 연결 예시
* 아래와 같이 DB.instance라는 하나의 인스턴스를 기반으로 a,b를 생성할 수 있다. 이를 통해 데이터베이스 연결에 관한 인스턴스 생성 비용을 아낄 수 있다.
* 실젤로 싱글톤 패턴은 Node.js에서 MongoDB데이터베이스를 연겨할 때 쓰는 mongoose모듈에서 사용된다
* mongoose의 데이터베이스를 연결할 때 쓰는 connect()라는 함수는 싱글톤 인스턴스를 반환합니다.
* Node.js에서 MySQL 데이터베이스를 연결할 때도 싱글톤 패턴이 쓰입니다.
  * 메인 모듈에서 데이터베이스 연결에 관한 인ㄴ스턴스를 정의하고 다른 모듈인 A 또는 B에서 해당 인스턴스를 기반으로 쿼리를 보내는 형식으로 쓰입니다.
```javascript
const URL = 'mongodb://localhost:27017/myapp'
const createConnection = url => ({"url": url})
class DB {
  constructor(url) {
    if(!DB.instance) {
      DB.instance = createConnection(url);
    }
    return DB.instance;
  }
  connect() {
    return this.instance;
  }
}
const a = new DB(URL);
const b = new DB(URL);
console.log(a === b) // true
```
### 싱글톤 패턴과 TDD
- 싱글톤 패턴은 TDD를 할 때 걸림돌이 된다. TDD를 할 때 단위 테스트 (unit test)를 주로 하는데, 단위 테스트는 테스트가 서로 독립적이어야 하며 테스트를 어떤 순서로든 실행할 수 있어야한다.

### 싱글톤 패턴과 의존성 주입
* 싱글톤 패턴은 사용하기 쉽고 싱용적이지만 **모듈 간의 결합을 강하게 만들 수 있다는 단점**이 있습니다.
* **의존성 주입**(DI, Dependency Injection)을 통해 모듈 간의 결합을 조금 더 느슨하게 만들어 해결할 수 있다.
* 의존성이란 종속성이라고도 하며, A가 B에 의존성이 있다는 것은 B의 변경 사항에 대해 A 또한 변해야 된다는 것을 의미합니다.
* <img width="484" alt="스크린샷 2023-12-18 오전 10 26 28" src="https://github.com/dja1716/TIL/assets/20631646/735c1dcd-293c-44d0-8c88-c02adaf23b7b">
* 위의 그림처럼 메인 모듈 (main module)이 '직접' 다른 하위 모듈에 대한 의존성을 주기보다는 중간에 의존성 주입자 (dependency injector)가 이 부분을 가로채 메인 모듈이 '간접'적으로 의존성을 주입하는 방식입니다. 이를 통해 메인 모듈 (상위 모듈)은 하위 모듈에 대한 의존성이 떠어지게 된다. 이를 '디커플링 된다' 고 한다.
* 의존성 주입의 장점: 모듈들이 쉽게 교체할 수 있는 구조가 되어 테스팅하기 쉽고 마이그레이션하기도 수월합니다. 또한, 구현할 때 추상화 레이어를 넣고 이를 기반으로 구현체를 넣어 주기 때문에 애플리케이션 의존성 방향이 일관되고, 애플리케이션을 쉡게 추론할 수 있으며, 모듈 간의 관계들이 명확해진다.
* 의존성 주입의 단점: 모듈들이 더욱더 분리되므로 클래스 숙 늘어나 복잡성이 증가되ㅗㄹ 수 있으며 약간의 런타임 패널티가 생기기도 한다.
* 의존성 주입 원칙: "상위 모듈은 하위 모듈에서 어떠한 것도 가져오지 않아야합니다. 또한 둘 다 추상화에 의존해야 하며, 이때 추상화는 세부 사항에 의존하지 말아야 합니다."
