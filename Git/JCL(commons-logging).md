> #### 스프링 부트의 로깅 의존성 관리

실무에서 제대로 동작하는 웹 어플리케이션을 만들기 위해서 학습한다. 

---

- SLF4J
- Logback 

위에 두 가지를 사용해서  로깅을 한다. 





### JCL(commons-logging)

- 로깅 추상화 라이브 러리 

아파치(자카르타) 커먼스 로깅을 줄여서 JCL 이라고 부른다. 

```java
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

private final Log log = LogFactory.getLog(getClass())

if( this.log.isDebugEnabled()){
    this.log.debug("Loding source"
        + StringUtils.arrayToCommaDelimitedString(source));
        }
```



로깅 라이브 러리 선택권은 애플리케이션 개발자의 것이라서 주로 로깅 추상화 라이브러리를 활용한다. 



로깅을 하려면 구현체를 찾아야 하는데 아래와 같은 방법이 있다.



- 설정 파일에서 찾기
- 클래스패스에서 Log4J 구현체 찾아보기
- JDK 1.4 에서 구동중인지 확인하기
- 아무것도 못찾으면 기본 구현체 사용





참고 

https://www.slideshare.net/whiteship/ss-47273947

