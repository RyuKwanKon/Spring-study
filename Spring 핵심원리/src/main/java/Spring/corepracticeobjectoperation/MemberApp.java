package Spring.corepracticeobjectoperation;

import Spring.corepracticeobjectoperation.member.Grade;
import Spring.corepracticeobjectoperation.member.Member;
import Spring.corepracticeobjectoperation.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberservice", MemberService.class);
        Member member = new Member(1L, "A", Grade.VIP);
    }
}
