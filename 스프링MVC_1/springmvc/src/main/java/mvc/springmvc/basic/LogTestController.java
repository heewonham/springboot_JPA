package mvc.springmvc.basic;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    // 현재 클래스 지정
    // @Slf4j 설정시 생략 가능
    // private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        // 로그 - 시간, 프로세스, 스레드, 메세지 출력
        // 해당 레벨의 하위까지 출력됨
        log.trace("trace log = {}",name);
        log.debug("debug log = {}",name);
        log.info("info log = {}", name);
        log.warn("warn log = {}",name);
        log.error("error log = {}",name);

        return "ok";
    }

}
