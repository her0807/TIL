## SpEL(spring Expression Language)

짧고 간단한 문법으로 필요한 데이터나 설정 값을 얻어올 수 있게 함

주로 @Value("$(config.value)")와 같은 방식으로 설정값을 주입 받는데 활용함.



### (evaluation) 값 평가

SpekParser 는 안에 들어있는 문자열을 평가해서 결과값을 만든다.



```java
ExpresstionParser p = new SpelExpressionParser();
Expression exp = p.parseExpression("hello");
String m = (String) exp.getValue(); // hello;
```

### Bean 의 Property 를 설정할 때 사용하는 방식

```java
@Component
public class SimpleComonent {
  @Value("#{ 1+1 }")
  int two;
  
   @Value("#{ ${ server.hostname } 1+1 }")
  int hostName; // ${ 를 하면, yml 파일 값을 가져옴
}
```

