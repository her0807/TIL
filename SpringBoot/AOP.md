### AOP(공통적인 처리)

관점 지향 프로그래밍이다.

- 로깅
- 트랜잭션 (스프링 mvc 사용하다보면, 내부적으로 aop 가 트랜잭션 시작과 끝을 처리해줌)
- 인증 (특정 부분에서 추가 인증이 필요할 때 사용함)



코드가 다소 복잡해지는 단점이 있음.



---

### 개념

### Aspect

여러 클래스나 기능에 걸쳐있는 관심사를 모듈화 한 것

ex) 트랜젝션 관리 Transactional 기능



### Advice

조언, AOP 에 실제로 적용하는 기능(로깅, 트랜잭선)



### Join Point

모듈화 된 곳 중 특정 지점에 연결 포인트



### Point cut

조인 포인트 중 에스펙트를 심어줄 위치



### Target Object

어드바이스가 심어질 위치



### AOP Proxy

특정 클래스에 aop 를 입혀줄 때  하는 작업을 뜻함.

주로 코드 제너레이션 라이브러리를 사용함.



### Weaving

어드바이스를 비지니스 로직에 심는 것을 뜻함



---

## 주로 쓰는 라이브러리



### AspectJ

aop 를 사용하기 위해 꼭 필요한 라이브 러리



1. 우선 aspect 를 생성한다 생성 방법은 아래와 같다

```java
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class UseFulAspect {
  
}
```



2. 포인트 컷을 지정해준다.

```java
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class UseFulAspect {
  
  @Pointcut("execution(*transfer(..))")
  private void anyOldTransfer(){
    
  }
  
}
```

포인트 컷은 조합을 한다. 

조건식이 있으니 인터넷에 찾아보자.



## Advice 정의

### Before Advice 

미리 정의된 포인트 컷의 바로 전에 doAccessCheck 가 실행됨.

로깅이나 , 알림을 보낼 때 사용

### After Returning Advice 

dataAccessOperation()라는 미리 정의된 포인트 컷에서 return이 발생된 후 실행



## Around Advice

비지니스 서비스 라는 포인트 컷의 전/후에 필요하 동작 제일 많이 씀.



```java
@Aspect
public class AroundExample {
  
  @Around("com.xyz.myapp.CommonPointcuts.businessService()")
  public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
    
    Object retVal = pjp.proceed();
    
    return reVal;
}
```

