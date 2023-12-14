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
