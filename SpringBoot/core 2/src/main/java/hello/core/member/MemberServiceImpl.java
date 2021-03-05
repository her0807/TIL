package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MemberServiceImpl implements MemberService {
//이걸로 가입을 하고 회원을 조회하기 위해서는 레포지토리에 저장소가 필요하다.


    private final MemberRepository memberRepository;


    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }
// 구현 객체를 선택해줘야한다. 메모리 멤버 레포로 하겠다.

    @Override
    public void join(Member member) {
        memberRepository.sava(member);
    }

    @Override
    public Member findMember(Long memberId) {


        return memberRepository.findById(memberId);
    }
}
