## substring 메소드 

#### 사용 방법

> ```
>  str.substring(indexStart, [indexEnd])
> ```



 문자열의 시작 인덱스, 끝 인덱스 만큼 문자열을 잘라서 반환해줍니다. 



시작 인덱스는 필수지만, 끝 인덱스는 입력하지않으면 자동으로 문자열의 제일 마지막이 설정됩니다. 



```java
String temp = "abcde";

str.substring(0, 2) // abc 의 값이 반환 됨
```

