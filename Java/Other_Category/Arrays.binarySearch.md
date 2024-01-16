### Arrays.binarySearch를 통해 이분탐색을 구현없이도 사용할 수 있다
- 예제
```java
int idx = Arrays.binarySearch(arr, x);
System.out.println(idx >= 0 ? "exist" : "not exist");
```
### 하지만 부족한 점이 많아, 실제로 구현해서 사용하는 케이스가 더 많을 것 같다
