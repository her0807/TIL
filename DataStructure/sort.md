## 정렬

### 1. 정렬 조건이 필요하다

오름차순, 내림차순

```java
static class Elem implements Comparable<Elem>{
  
  // Elem 은 내가 정렬할 원소의 형태를 구조체로 표현해야하고, Comparable 을 상속받아야하고, 무조건 Int 를 반환해야함.
  
  // return 이 음수라면 내가 먼저,양수 쟤가먼저 0 같음을 의미함.
  
  
  pubilc int num, idx;
  
  @Override
  public int compareTo(Elem other) {
    return num - other.num;
  }
}
```



### 2. 시간복잡도는 약 O(N log N ) 이다.

Arrays.sort() 를 사용하면  

최선 O(N), 최악(N2) 평균 O(N log N)



### 3. In-place  (primitive 원소)/ Stable 여부 (Object 원소)

정렬 알고리즘이 제자리 한가?

정렬하는 과정에서 N 에 비해 충분히 무시할만한 개수의 메모리 만큼 사용하는가?



Stable 여부 (Object 원소) - Tim sort (selete marge 두개  합친거임)

정렬알고리즘이 안정한가? 동등한 위상의 원소들의 순서가 보존 되는가



### 특성

- 같은 정보들은 인접함
- 각 원소마다 가까운 원소는 양옆 중에 있다.

