package tobyspring.myboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


public class HelloController {
    public String hello(String name){
        return "hello " + name;
    }
}
