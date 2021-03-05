package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;



@Component
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store =  new HashMap<>();
    // 동시성 이슈가 있을 수 있다.


    @Override
    public void sava(Member member) {
        store.put(member.getId(),member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
