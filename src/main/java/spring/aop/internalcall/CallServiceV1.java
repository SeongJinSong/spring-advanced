package spring.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV1 {
    private CallServiceV1 callServiceV1;

    /**
     * 생성자 주입을 하면 자기 자신을 주입하는 것이기 때문에
     * 순환 참조 문제가 생긴다.
     */
    @Autowired
    public void setCallServiceV1(CallServiceV1 callServiceV1){
        this.callServiceV1 = callServiceV1;
    }

    public void external(){
        log.info("call external");
        callServiceV1.internal(); //외부 메서드 호출
    }
    public void internal(){
        log.info("call internal");
    }
}
