출처: chatGPT

### 특징
- 제자리 정렬(in-place sorting) 알고리즘
- 추가 메모리가 필요하지 않음
- 삽입 정렬의 기본 아이디어는 배열을 정렬된 부분과 정렬되지 않은 부분으로 나누고, 정렬되지 않은 부분에서 다음 아이템을 정렬된 부분의 올바른 위치로 반복적으로 삽입
- 시간복잡도(time complexity): O(n^2)
- 이럴 때 효율적: 데이터가 이미 부분적으로 정렬된 경우에는 내부 루프가 빠르게 종료

### 예시
```Java
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // key보다 큰 arr[0..i-1]의 요소를 현재 위치보다 한 칸 오른쪽으로 이동
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // key를 올바른 위치에 놓습니다.
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        insertionSort(arr);
        System.out.println("정렬된 배열:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

```

### 제자리 정렬이란
- 정렬 알고리즘의 한 종류로, 추가적인 메모리 공간을 사용하지 않고 원래의 입력 데이터를 정렬하는 것을 의미
- 다른말로, 정렬을 수행하는 동안 원래의 데이터 배열 내에서 요소들의 위치를 변경하면서 정렬
- 원래의 데이터 구조를 유지하면서 정렬
- 입력 데이터를 변경하면서 정렬을 수행하므로 메모리 효율적
- 예시: 삽입 정렬(Insertion Sort)과 선택 정렬(Selection Sort)

### 제자리 정렬의 반대 개념: out-of-place sorting
- 렬을 수행할 때 새로운 메모리 공간을 할당하고 정렬된 결과를 그 새로운 메모리에 저장
- 원래 데이터 배열을 변경하지 않으므로 원래 데이터를 보존하고 싶을 때 유용
- 그러나 추가적인 메모리 공간이 필요하며 메모리 사용량이 더 많을 수 있음
- 예시: 병합 정렬(Merge Sort)과 퀵 정렬(Quick Sort)
