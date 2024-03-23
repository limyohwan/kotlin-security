package com.example.demo.common.dto

import com.example.demo.common.status.ResultCode

data class BaseResponse<T>(
    val resultCode: String = ResultCode.SUCCES.name,
    val data: T? = null,
    val message: String = ResultCode.SUCCES.msg
)