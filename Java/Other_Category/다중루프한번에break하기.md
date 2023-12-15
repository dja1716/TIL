### 궁금한 점
* 코딩문제를 풀다보니, 다중 루프를 한번에 나오는 방법이 있는지 궁금했다.
* 다중 루프에 한번의 break으로 루프 전체를 빠져나올 수 있을까?
* 그래서 chatGPT에게 물어봤다.

### 해답
* 과거 컴파일러 및 어셈블리 수업 때 MIPS에서 사용하던 label의 개념을 Java에서도 사용 가능했다.
* 방법은 다음과 같다

```Java
outerLoop:
for(int i = 1; i < max; i++) {
    for(int j = 1; j < max; j++) {
        for(int k = 1; k < max; k++) {
            int temp = arrN[i] + arrN[j] + arrN[k];
            if(temp == target) {
                result = 1;
                break outerLoop;
            }
            if(temp > target) break;
        }
    }
}
```
유용할지는 잘 모르겠디만 매우 신기했다^^.
