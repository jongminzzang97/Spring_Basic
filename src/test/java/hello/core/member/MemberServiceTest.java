package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {


    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = annotationConfigApplicationContext.getBean("memberService", MemberService.class);
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join((member));
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }


//    @Test
//    // This will fail as isEqualTo() compare object references.
//    void isEqualToTest() {
//        Member memberA = new Member(1L, "memberA", Grade.VIP);
//        Member memberB = new Member(1L, "memberA", Grade.VIP);
//
//        Assertions.assertThat(memberA).isEqualTo(memberB);
//    }


}
