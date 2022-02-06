package spring.proxy.config.v1_proxy.concrete_proxy;

import spring.proxy.app.v2.OrderRepositoryV2;
import spring.proxy.app.v2.OrderServiceV2;
import spring.proxy.trace.TraceStatus;
import spring.proxy.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {
    private final OrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        /**
         * 자바에서 자식클래스를 생성하는 경우 부모클래스의 생성자를 호출해준다.
         * 기본생성자가 있는경우 자바에서 묵시적으로 호출해준다.
         *
         * 기본생성자가 없는 경우 자식생성자에서 부모 생성자를 명시적으로 호출해야하는데
         * 부모의 기능을 안쓰고 proxy 로 사용할 예정이기 때문에 super(null); 을 쓴다.
         */
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderService.orderItem()");
            //target 호출
            target.orderItem(itemId);
            logTrace.end(status);
        }catch (Exception e){
            logTrace.exception(status, e);
            throw e;
        }
    }
}
