package hello.core;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


class CoreApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void configurationDeep() {
		ApplicationContext ac = new
				AnnotationConfigApplicationContext(AppConfig.class);
		//AppConfig도 스프링 빈으로 등록된다.
		AppConfig bean = ac.getBean(AppConfig.class);

		System.out.println("bean = " + bean.getClass());
		//출력: bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$bd479d70
	}

}
