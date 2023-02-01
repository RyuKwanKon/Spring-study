package Spring.corepracticeobjectoperation.repository;

import Spring.corepracticeobjectoperation.member.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
