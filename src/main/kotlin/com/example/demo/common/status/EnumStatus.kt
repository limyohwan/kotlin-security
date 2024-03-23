package com.example.demo.common.status

enum class Gender(val desc: String) {
    MALE("남"),
    FEMALE("여")
}

enum class ResultCode(val msg: String) {
    SUCCES("정상 처리 되었습니다."),
    ERROR("에러가 발생했습니다.")
}