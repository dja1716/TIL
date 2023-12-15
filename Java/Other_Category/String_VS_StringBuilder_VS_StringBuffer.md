* 자바로 코딩테스트 문제를 풀다보니, String, StringBuider, StringBuffer에 대해 궁금증이 생겨 chatGPT에게 물어보았다.
* 출처: chatGPT
* 출처: https://madplay.github.io/post/difference-between-string-stringbuilder-and-stringbuffer-in-java

## String vs StringBuilder vs StringBuffer
1. String
불변성(Immutable): 한 번 생성된 String 객체는 변경할 수 없습니다. 문자열을 변경하면 새로운 String 객체가 생성됩니다.  
스레드 안전(Thread Safe): 불변성으로 인해 다중 스레드 환경에서 안전하게 사용할 수 있습니다.  
주요 메서드:  
concat(String str): 다른 문자열을 현재 문자열 끝에 추가합니다.  
substring(int beginIndex, int endIndex): 문자열의 특정 부분을 추출합니다.  
length(): 문자열의 길이를 반환합니다.  
charAt(int index): 특정 인덱스의 문자를 반환합니다.  
replace(char oldChar, char newChar): 문자열 내의 문자를 다른 문자로 바꿉니다.  
3. StringBuilder
가변성(Mutable): StringBuilder 객체는 생성 후에도 내용을 변경할 수 있습니다.  
스레드 안전하지 않음(Not Thread Safe): 동시에 여러 스레드가 접근하면 문제가 발생할 수 있습니다.  
성능: 문자열 조작이 빈번한 상황에서 String보다 성능이 좋습니다.  
주요 메서드:  
append(String str): 문자열을 끝에 추가합니다.  
insert(int offset, String str): 지정된 위치에 문자열을 삽입합니다.  
delete(int start, int end): 시작과 끝 인덱스 사이의 문자열을 삭제합니다.  
reverse(): 문자열을 뒤집습니다.  
toString(): StringBuilder의 내용을 String으로 변환합니다.  
4. StringBuffer  
가변성(Mutable): StringBuffer도 가변적입니다.  
스레드 안전(Thread Safe): StringBuffer의 모든 공개 메서드는 synchronized되어 있어 멀티스레드 환경에서 안전합니다.  
성능: StringBuilder보다는 약간 느릴 수 있습니다(동기화 오버헤드 때문에).  
주요 메서드:  
append(String str): 문자열을 끝에 추가합니다 (StringBuilder와 유사).  
insert(int offset, String str): 특정 위치에 문자열을 삽입합니다 (StringBuilder와 유사).  
delete(int start, int end): 특정 범위의 문자열을 삭제합니다 (StringBuilder와 유사).  
reverse(): 문자열을 뒤집습니다 (StringBuilder와 유사).  
toString(): StringBuffer의 내용을 String으로 변환합니다.    

* String은 변경이 적고 읽기만 주로 하는 경우에 적합하며, StringBuilder와 StringBuffer는 문자열이 자주 변경되는 상황에 적합합니다. 그 중 StringBuilder는 단일 스레드, StringBuffer는 멀티스레드 환경에서 권장됩니다.  

## 그렇다면 얼마나 자주 변경될 때 최적화가 필요할까?
* 3만번 연산 기준으로 String은 1~2초 정도의 시간이 소요되지만, StringBuilder와 StringBuffer는 거의 시간소요가 없는 것을 볼 수 있다.
* 요즘 Java는 String도 연산과정에서 StringBuilder를 사용하도록 변경되었다고 한다.
* 하지만 가능하다면, StringBuilder를 사용해보자
