package tobyspring.myboot;

import jdk.jfr.ContentType;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomApplication {
    public static void main(String[] args) {
//        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("frontController", new HttpServlet(){
                HelloController controller = new HelloController();
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    //인증, 보안, 다국어처리 등 공통 기능 처리
                    if(req.getRequestURI().equals("/hello")){


                        String name = req.getParameter("name");
                        controller.hello(name);
                        resp.setStatus(HttpStatus.OK.value());
                        resp.setHeader(HttpHeaders.CONTENT_TYPE,MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println("hello Servlet " + name);
                    }
                    else if(req.getRequestURI().equals("/hello")){
                        ///else
                    }
                    else{
                        resp.setStatus(HttpStatus.NOT_FOUND.value());

                    }
                }
            }).addMapping("/*");
        });
        webServer.start();
    }
}
