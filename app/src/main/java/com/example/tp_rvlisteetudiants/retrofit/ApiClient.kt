package com.example.tp_rvlisteetudiants.retrofit

import com.example.tp_rvlisteetudiants.models.Etudiant
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("01f7fecc-a8f1-4c30-9f56-e95f4c47183c")
    suspend fun getTousLesEtudiantsEtudiants(): Response<ArrayList<Etudiant>>
}