package com.app.uh1l.model

data class StatusResponse<T,S>(val data: T, val statusCode: S)

data class BasicStatusResponse(val status: Int)