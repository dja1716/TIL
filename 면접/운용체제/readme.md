### 운용체제
- 시스템의 자원과 동작을 관리하는 소프트웨어
- 프로세스, 저장장치, 네트워킹, 사용자, 하드웨어를 관리
### 메모리 구조 (RAM)
- Code, Data, Heap, Stack
- https://tcpschool.com/c/c_memory_structure
### 프로세스, 스레드
- 프로세스: 실행중인 프로그램
- 스레드: 프로세스 안 실행 단위
- https://gmlwjd9405.github.io/2018/09/14/process-vs-thread.html
### CPU 스케줄러
- 준비큐 있는 프로세스에 대해 CPU 할당하는 방법
- 선점 vs 비선점
- 선점: 빼앗음, 비선점: 기다림
- https://velog.io/@jeongopo/%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9C-%EC%8A%A4%EC%BC%80%EC%A4%84%EB%A7%81-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
### 가상 메모리
- 사용하는 부분만 메모리에 올리고, 나머지는 디스크에 보관하는 기법
- 모든 프로세스에게 메모리를 할당하기에는 메모리의 크기가 한계가 있어서 사용하는 방법
- https://ahnanne.tistory.com/15
### 데드락
- 프로세스가 자원을 얻지 못해 다음 작업을 못하는 상태
- 발생조건 중요
- https://ko.wikipedia.org/wiki/%EA%B5%90%EC%B0%A9_%EC%83%81%ED%83%9C
