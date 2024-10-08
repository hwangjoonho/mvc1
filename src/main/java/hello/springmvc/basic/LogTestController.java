package hello.springmvc.    basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // String으로 반환할때 view이름으로 읽는것이 아닌 순수 문자열로 http 메세지 body 부분에 넣음
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());
//    @Slf4j로 대체가능

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

//        log.trace("trace log={}"+ name); // 쓸모없는 자원 사용됨

        log.trace("trace log={}", name);


        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);
        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X
        log.debug("String concat log=" + name);
        return "ok";
    }
}
