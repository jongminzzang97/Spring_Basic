package hello.core.member;

// 구현체가 하나만 있을 때는 interface 뒤에 impl만 툽여서 사용하는 것이 관례
public class MemberServiceImpl implements MemberService {

    // 이 부분에서 MemoriMemberRepository를 직접 할당한다는 점에서 좋지 못하다.
    // 후에 변경이 있다면 코드를 직접수정해야함
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findyById(memberId);
    }
}
