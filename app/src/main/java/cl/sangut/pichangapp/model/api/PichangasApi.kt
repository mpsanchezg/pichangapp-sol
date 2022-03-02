package cl.sangut.pichangapp.model.api

import cl.sangut.pichangapp.model.data.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface PichangasApi {
  @GET("pichangas")
  suspend fun getUpcomingPichangas(): Response<List<Pichanga>>

  @GET("pichangas/visitor/{userId}")
  suspend fun getJoinedPichangas(@Path("userId") userId: String): Response<List<Pichanga>>

  @GET("user/{userId}/pichangas")
  suspend fun getOrganizedPichangas(@Path("userId") userId: String): Response<List<Pichanga>>

  @POST("user/{userId}/pichangas")
  suspend fun createPichanga(@Path("userId") userId: String, @Body pichanga: Pichanga)
}
