package Spring.corepracticeobjectoperation.lifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);
    }

    public void call(String message) {
        System.out.println("call: " +url + " message = " + message);
    }

    public void connect() {
        System.out.println("connect: " + url);
    }
    public void disconnect(){
        System.out.println("close");
    }

    public void setUrl(String s) {
        this.url = s;
    }
    //초기화 method
    //Spring Bean에 의존관계와 객체 생성이 모두 끝난다음에 호출
    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메시지");
    }
    //종료 method
    //Spring 컨테이너가 사라지기 전 안전하게 종료
    @PreDestroy
    public void close() {
        disconnect();
    }
}
