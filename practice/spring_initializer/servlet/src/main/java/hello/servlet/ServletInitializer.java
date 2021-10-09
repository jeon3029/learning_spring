package hello.servlet;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//SpringBoot 웹 애플리케이션을 배포할 때는 주로 embedded tomcat이 내장된 jar파일을 이용한다.
//하지만 특별한 경우에는 전통적인 배포 방식인 war 파일로 배포를 진행해야 하는 경우가 있을 수 있다.
//이럴 경우 SpringBootServletInitializer를 상속받으면 된다.
//* 참고 : https://serverwizard.tistory.com/165
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
