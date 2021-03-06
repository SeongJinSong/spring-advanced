package spring.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import spring.proxy.config.AppV1Config;
import spring.proxy.config.AppV2Config;
import spring.proxy.config.v1_proxy.ConcreteProxyConfig;
import spring.proxy.config.v1_proxy.InterfaceProxyConfig;
import spring.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import spring.proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import spring.proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import spring.proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import spring.proxy.config.v4_postprocessor.BeanPostProcessorConfig;
import spring.proxy.config.v5_autoproxy.AutoProxyConfig;
import spring.proxy.config.v6_aop.AopConfig;
import spring.proxy.trace.logtrace.LogTrace;
import spring.proxy.trace.logtrace.ThreadLocalLogTrace;

//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV1.class)
//@Import(ProxyFactoryConfigV2.class)
//@Import(BeanPostProcessorConfig.class)
//@Import(AutoProxyConfig.class)
@Import(AopConfig.class)
@SpringBootApplication(scanBasePackages = "spring.proxy.app") //주의
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace(){
		return new ThreadLocalLogTrace();
	}
}
