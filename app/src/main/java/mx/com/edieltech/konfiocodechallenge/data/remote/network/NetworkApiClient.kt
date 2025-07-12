package mx.com.edieltech.konfiocodechallenge.data.remote.network

import mx.com.edieltech.konfiocodechallenge.data.remote.response.GetDogListResponse
import retrofit2.http.GET

interface NetworkApiClient {
    @GET("1151549092634943488")
    suspend fun getDogs(): List<GetDogListResponse>
}