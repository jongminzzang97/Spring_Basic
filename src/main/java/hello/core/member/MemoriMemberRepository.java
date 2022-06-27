package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoriMemberRepository implements MemberRepository {

    // 동시성 이슈가 있을 수 있으므로 ConcurrentHashMap 을 사용하는 것이 더 맞다
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findyById(Long memberId) {
        return store.get(memberId);
    }
}
