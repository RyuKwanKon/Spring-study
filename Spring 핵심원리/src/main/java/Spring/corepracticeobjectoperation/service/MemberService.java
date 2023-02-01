package Spring.corepracticeobjectoperation.service;

import Spring.corepracticeobjectoperation.member.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
