package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// public class NetworkClient implements InitializingBean, DisposableBean{
public class NetworkClient {
    

    private String url;

    public NetworkClient(){
        System.out.println("생성자를 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");

    }

    public void setUrl(String url){
        this.url = url;
    }

    // 서비스 시작할 때 호출하는 메서드
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){

        System.out.println("call : " + url + " message : " + message);
    }

    //서비스 종료 시점 호출
    public void disconnect(){
        System.out.println("close : " + url);
    }

    
    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet()");
        connect();
        call("초기화 연결 메시지");
    }

    
    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.destroy()");
        disconnect();
        
    }


}
