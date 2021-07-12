package hello.core.singleton;

public class SingletonService {
    

    private static final SingletonService instance = new SingletonService(); // static이라고 되어 있으면 static 영역에 하나만 올라갈 수 있음

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }
    public void logic(){
        
        System.out.println("싱글톤 객체 생성 로직");
         
    }
}
