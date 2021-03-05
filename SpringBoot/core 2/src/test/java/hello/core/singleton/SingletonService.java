package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){ // 밖에서 new로 호출을 막음

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
    public static void main(String[] args) {
        SingletonService singletonService = new SingletonService();
    }
}
