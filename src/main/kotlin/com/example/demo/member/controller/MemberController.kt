package com.example.demo.member.controller

import com.example.demo.common.dto.BaseResponse
import com.example.demo.member.dto.MemberRequest
import com.example.demo.member.service.MemberService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/member")
@RestController
class MemberController(
    private val memberService: MemberService
) {
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid memberRequest: MemberRequest): BaseResponse<Unit> {
        return BaseResponse(message = memberService.signUp(memberRequest))
    }
}