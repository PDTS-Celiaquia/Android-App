package ar.edu.mdp.fi.celiaquia.network

import ar.edu.mdp.fi.celiaquia.modelo.Receta
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface RecetasApiService {
    @GET("recetas")
    fun getRecetasAsync(): Deferred<List<Receta>>
}

object Network {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl("http://localhost:8080").build()

    val recetasService : RecetasApiService by lazy {
        retrofit.create(RecetasApiService::class.java)
    }
}