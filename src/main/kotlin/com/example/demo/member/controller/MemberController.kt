package com.example.demo.member.controller

import com.example.demo.common.authority.TokenInfo
import com.example.demo.common.dto.BaseResponse
import com.example.demo.common.dto.CustomUser
import com.example.demo.member.dto.LoginRequest
import com.example.demo.member.dto.MemberRequest
import com.example.demo.member.dto.MemberResponse
import com.example.demo.member.service.MemberService
import jakarta.validation.Valid
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @PostMapping("/login")
    fun login(@RequestBody @Valid loginRequest: LoginRequest): BaseResponse<TokenInfo> {
        val tokenInfo = memberService.login(loginRequest)
        return BaseResponse(data = tokenInfo)
    }

    @GetMapping("/info")
    fun searchMyInfo(): BaseResponse<MemberResponse> {
        val userId = (SecurityContextHolder.getContext().authentication.principal as CustomUser).userId
        val response = memberService.searchMyInfo(userId)
        return BaseResponse(data = response)
    }
}