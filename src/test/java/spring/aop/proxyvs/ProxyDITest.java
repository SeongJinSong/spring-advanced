package spring.aop.proxyvs;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import spring.aop.member.MemberService;
import spring.aop.member.MemberServiceImpl;

@Slf4j
@SpringBootTest(properties = {"spring.aop.proxy-target-class=true"}) //JDK 동적 프록시
@Import(ProxyDIAspect.class)
public class ProxyDITest {
    @Autowired
    MemberService memberService;

    @Autowired
    MemberServiceImpl memberServiceImpl;

    @Test
    void go(){
        log.info("memberService class={}", memberService.getClass());
        log.info("memberServiceImpl class={}", memberServiceImpl.getClass());
        memberServiceImpl.hello("hello");
    }
}
