package hello.core.xml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import hello.core.member.MemberService;

public class XmlAppContext {
    
    @Test
    void XmlAppContext(){
        // Resources에서 해당 이름을 찾아서 적용
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml"); 
        MemberService bean = ac.getBean("memberService", MemberService.class);
    
        Assertions.assertThat(bean).isInstanceOf(MemberService.class);
        
    }

}
