package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import hello.servlet.TestDto;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan 
// 스프링 부트는 서블릿을 직접 등록해서 사용할 수 있도록 @ServletComponentScan 을 지원
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
