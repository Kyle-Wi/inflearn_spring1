package hello.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
    

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        System.out.println("myLogger : " + myLogger.getClass()); // 가짜 클래스를 만들어서 제공하는 기술 프록시

        myLogger.log("controller test");
        logDemoService.logic("testId");
    
        return "OK";
    }
}
