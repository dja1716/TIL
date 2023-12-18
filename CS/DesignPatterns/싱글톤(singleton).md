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
