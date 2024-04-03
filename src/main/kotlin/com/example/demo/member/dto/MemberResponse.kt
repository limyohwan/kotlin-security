package com.example.demo.member.dto

data class MemberResponse(
    val id: Long,
    val loginId: String,
    val name: String,
    val birthDate: String,
    val gender: String,
    val email: String
)
