## Spring Resource

스프링을 위한 설정값들을 위해 특정 파일을 접근하는 용도로 사용함,

사실 업무 할 때는 크게 사용하지 않음

스프링이 내부적으로 이렇게 동작하겠구나 했던 부분

InputStreamSource 에서 상속받은 것들과 그 구현체들이 있음

### UrlResource

java.net.URL을 래핑한 버전, 다양한 종류(File, http ) 등의 prefix 로

로  접근 유형 판단 리소스에 접근 가능하지만 기본적으로는 https 로 원격접속

### ClassPathResource

코드 소스를 빌드한 결과 하위의 리소스 접근시 사용함

yml, xml 등등.. 특정 위치에 넣어 둘 때 전체 경로를 적어둘 필요없이

이 설정을 해주면 바로 접근 가능함

### FileSystemResource

이름과 같이 File을 다루기 위한 리소스 구현체임

특정 파일 경로를 찍어서 파일에 접근할 때 사용함



### SevletContextResource

서블릿에 있는 어플리케이션 루트에 접근하기 위한 설정들이 여기 들어가있음.



ApplicationContext 는 스프링에 집약적인 내용들이 모여있는