## Null Safety

널을 최초에 설계한 사람이 10억불짜리 실수였다고 얘기함 ㅋ

널 안정성을 높이는 방법

```java
public void method(String request){
  if(request == null) return;
  
  Systen.out.printf(request.toUpperCase());
}
```

1. IDE 에서 경고를 표시함. 1차적인 문제를 방지함

### NonNull Annotation

- 해당 값이나 함수 등이 null 이 아님을 나타냄

- org.springframework.lang.NonnNull 사용

  1. 파라미터에 붙이는 경우

     널 데이터가 들어오는 것을 사전에 방지함

  ```java
  public void method(@NonNull String request){
    if(request == null) return;// 이게 필요 없음.
    
    Systen.out.printf(request.toUpperCase());
  }
  ```

  2. 프로퍼티에 붙이는 경우. 

     null 을 저장하는 경우 경고를 안내

     ```java
     @NonNull
     String request 
       
     public void method(){
       request = null ;// 여기서 경고
       
      Systen.out.printf(request.toUpperCase());
     }
     ```



### Nullable Annotation

이 데이터가 항상 널일 수 있다고 명시함.



### Null 관련 어노테이션 참고

Jet brain - notnull

Lombok - NonNull;

