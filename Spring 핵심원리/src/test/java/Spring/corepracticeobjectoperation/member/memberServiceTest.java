package Spring.corepracticeobjectoperation.member;

import Spring.corepracticeobjectoperation.AppConfig;
import Spring.corepracticeobjectoperation.service.MemberService;
import Spring.corepracticeobjectoperation.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class memberServiceTest {
    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join(){
        //given
        Member member = new Member(1L, "A", Grade.VIP);

        //when
        memberService.join(member);
        Member member1 = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(member1);
    }
}
