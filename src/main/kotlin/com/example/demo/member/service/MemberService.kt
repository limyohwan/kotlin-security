package com.example.demo.member.service

import com.example.demo.common.exception.InvalidInputException
import com.example.demo.member.dto.MemberRequest
import com.example.demo.member.entity.Member
import com.example.demo.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    fun signUp(memberRequest: MemberRequest): String {
        var member: Member? = memberRepository.findByLoginId(memberRequest.loginId)
        if (member != null) {
            throw InvalidInputException("loginId", "이미 등록된 ID 입니다.")
        }

        member = memberRequest.toEntity()
        memberRepository.save(member)

        return "회원가입이 완료되었습니다."
    }
}