## Validation 

유효성 검증, 서버에 요청에서 잘못되 내용이 있는지 꼼꼼하게 검증하는 것

실제로 개발자가 주로 챙겨야하는 검즈은 크게 두 종류로 나뉜다.



### 데이터 검증

- 데이터의 존재 유무
- 문자열 길이 , 숫자형은 값의 범위
- Email , 신용카드와 같은 특정 형식에 맞춘 데이터 

### 비지니스 검증

- 서비스 정책에 따른 검증
- 배달 앱인 경우 배달 요처응ㄹ 할 떄 해당 주문건이 결제 완료 상태인지 한번 더 확인.
- 경우에 따라 외부 API 를 호출하거나 DB 의ㅣ 데이터까지 조회하여 검증하는 경우도 존재.



스프링에서 vaildation 은 웹 레이어에 종속적이지 않은 방법. 

데이터 검증에 가까움

### Java bean Vaildation

자바 빈은 데이터를 쉽게 저장했다가 꺼낼 수 있는 변수와 get/set 이 있는 클래스라고 말했음.

그 상태에서 자바 빈 어노테이션으로 검증 방법을 명시함



``` java
public class Member {
  @NotBlank(message="이름을 입력해주세요.")
  @Size(max=64, message="이름의 최대 길이는 64자 입니다.")
  private String name;
  @Min(0,"나이는 0보다 커야합니다.")
  private int age;
  @Email("이메일 형식이 잘못되었습니다.")
  private String email;
}
```



이렇게 붙인다고 검증이 진행되는게 아니라.  Controller 에서 @RequestBody 에 달아야

자바 빈 벨류데이트를 수행한 후 문제가 없을 때만 메서드 내부로 진입된다.

검증 중 실패하면 `MethodArgumentNotValidException` 이 발생한다.

```java
@PostMapping(value ="/member")
public MemberController(@Valid @RequestBody final Member){
  /// 내용
  
}
```

---



### 주의사항

- Validation 이 너무 여러군데 흩어져 있으면 테스트 및 유지 보수성이 떨어짐
- 중복 벨류데이션을 하게 됨. (정책 변경시 코드를 전부 수정해야함)
- 다른 검증 : 여러군데서 다른 정책을 따르는 검증이 수햄ㅇ됨

가능한 벨류데이션은 로직 초기에 수행 후 실패 시에는 예외를 던지는 것이 편함



### 실무 활용 패턴

- 요청 duo 에서 자바빈 벨리데이션으로 단순 데이터 (유무, 형식 범위 )를 1차로 검증
- 로직 초기에 2차로 비지니스 검증 ㅎ루 실패시 Custom Exception 에러 코드를 저장해서 던짐
- ErrorMessage를 입력해서 예외를 던지도록 하고 응답 생성



## Sptring validatoer 장단점

자바 빈 벨리데이션에 비해 복잡한 검증 가능하지만, 코드를 찾기가 어려움. 

일부 비지니스적인 검증이 들어가는 경우가 있음. 





## Data Binding

외부서버의 요청 데이터를 특정 도메인 객체에 저장해서 우리 프로그램에 request에 담아주는 것을 뜻함. 



### Converter<S,T> Interface

s 라는 타입을 받아서 t 타입으로 변환해주는 인터페이스

-> 만약에 json 형식에 데이터를 member 로 바꾸고 싶다?



```java
class Member {
  private int id;
  private String name;
  
}

@Component
public class MemberConverter implements Converter<String, Member>{
  @Ovverride
  public Member convert(String source){
    return objectMapper.readValue(source, Member.class);
  }
}

// 구현 원리는 Converter 를 상속받은 클래스를 구현하고, Spring bean 으로 등록(@ Component)
// 그러면 스프링 내에 ConversionService 라는 내장된 서비스에서 컨벌터 구현체 빈들을 리스트로 등록
// 외부 데이터가 들어 올 때 소스 타입 -> 타겟 타입에 등록된 형식과 일치하면 해당 컨벌터가 동작하는 형태임
-> @RequestBody 가 key :value 값을 보고 특정 객체로 바꿔주는 역할을 했던것임.
```



## Formatter

특정 객체와 String 간의 변환을 담당함

아래는 Data -> String 간의 변환을 수행하는것임.

```java
package org.springframework.format.datetime
  
  public final class DateFormatter implements Formatter<Date> {
    public String print(Date date, Locale locale) {
      return getDateFormat(locale).format(date);
    }
    
    public Date parse(String formatted, Locale locale) throws ParseException {
      return getDateFormat(locale).parse(formatted);
    }
  }
```

이것도 스프링 빈으로 등록하면 자동으로 컨벌션서바스에 등록시켜줘서 자동으로 동작하게 된다,

