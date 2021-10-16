package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http body 에 string 을 넣어줌
// 기존 Controller 와 차이 있음
@RestController
@Slf4j //private... Logger 선언 귀찮을 때 대체할 수 있음
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        //앞으로 이런방식 권장하지 않음
        System.out.println("name = " + name);

        log.trace(" trace my log="+ name);

        log.trace("trace log={}", name);

        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);
        return "ok";
    }
}
