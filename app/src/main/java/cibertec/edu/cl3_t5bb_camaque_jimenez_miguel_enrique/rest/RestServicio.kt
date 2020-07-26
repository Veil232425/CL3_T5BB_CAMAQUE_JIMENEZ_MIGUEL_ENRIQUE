package cibertec.edu.cl3_t5bb_camaque_jimenez_miguel_enrique.rest

import cibertec.edu.cl3_t5bb_camaque_jimenez_miguel_enrique.tools.Constantes
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RestServicio {
    private var retrofit: Retrofit? = null
    public fun getSERVICIO(): Retrofit? {
        if (retrofit == null) {
            val gson = GsonBuilder().setLenient().create()
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            retrofit = Retrofit.Builder()
                .baseUrl(Constantes.ENDPOINT)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return retrofit
    }
}