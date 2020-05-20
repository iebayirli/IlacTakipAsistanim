package com.example.ilactakipasistanim.rest


import com.app.uh1l.model.BasicStatusType
import com.app.uh1l.model.StatusResponse
import com.example.ilactakipasistanim.model.enabiz.EnabizRequest
import com.example.ilactakipasistanim.model.enabiz.EnabizResponse
import com.example.ilactakipasistanim.model.enabiz.Medicines
import retrofit2.http.Body
import retrofit2.http.POST

interface EnabizLoginService {
    @POST("getIlaclar")
    suspend fun login(@Body loginRequest: EnabizRequest): StatusResponse<ArrayList<Medicines>,BasicStatusType>
}