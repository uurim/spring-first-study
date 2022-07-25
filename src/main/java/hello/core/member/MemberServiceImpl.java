package hello.core.member;

//구현체가 하나인 경우 관례상 인터페이스명 뒤에 Impl이라고 작성함
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(long memberId) {
        return memberRepository.findById(memberId);
    }
}
