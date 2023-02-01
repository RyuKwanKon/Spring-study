package Spring.corepracticeobjectoperation.beanfind;

import Spring.corepracticeobjectoperation.AppConfig;
import Spring.corepracticeobjectoperation.discount.DiscountPolicy;
import Spring.corepracticeobjectoperation.member.Member;
import Spring.corepracticeobjectoperation.member.memberServiceTest;
import Spring.corepracticeobjectoperation.repository.MemberRepository;
import Spring.corepracticeobjectoperation.repository.MemoryMemberRepository;
import Spring.corepracticeobjectoperation.service.MemberService;
import Spring.corepracticeobjectoperation.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberservice", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
        //오른쪽 함수를 실행하면 예외가 떤져져야한다.
        //예외가 Throws됐기 때문에 성공이 떠야정상
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxx", MemberService.class));
    }

}
