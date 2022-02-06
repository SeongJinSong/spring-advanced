package spring.proxy.decorator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.proxy.decorator.code.DecoratorPatternClient;
import spring.proxy.decorator.code.RealComponent;

@Slf4j
public class DecoratorPatternTest {
    @Test
    void noDecorator(){
        RealComponent realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }
}
