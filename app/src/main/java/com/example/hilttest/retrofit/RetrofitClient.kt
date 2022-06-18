package com.example.hilttest.retrofit

import android.content.Context
import com.google.gson.JsonArray
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RetrofitClient @Inject constructor() {

    fun <T> buildService(service: Class<T>, context: Context?): T {

        val retrofit = Retrofit.Builder()
            .baseUrl(ClientConfig.ServerURL)
            .addConverterFactory(GsonConverterFactory.create())
//        .client(client)
            .client(okhttpClient(context))
            .build()

        return retrofit.create(service)
    }

    private fun okhttpClient(context: Context?): OkHttpClient {

        return OkHttpClient.Builder()
            .readTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS)



            .addInterceptor(Interceptor { chain: Interceptor.Chain ->
//            String accessToken = SharePrefManager.getToken(context); // must be inside here
                val request = chain.request()
                    .newBuilder() //                    .addHeader("Authorization", "Bearer " + SharePrefManager.getToken(context))
                    .addHeader("Authorization", "Bearer " + "SharePrefManager.getToken(context)")
                    .addHeader("Accept", "application/json")
                    .build()
                chain.proceed(request)
            })


            // handle 401
            .authenticator(object : Authenticator { @Throws(IOException::class)
            override fun authenticate(route: Route?, response: Response): Request? {

                val request = RetrofitClient().buildService(APIServices::class.java , context)
                val  call = request.getUserList()
                // response if retrofit
                val tokenModelResponse: retrofit2.Response<JsonArray?> = call!!.execute()

                if (tokenModelResponse.isSuccessful()){
                    return response.request().newBuilder()
                        .removeHeader("Authorization")
                        .removeHeader("Accept")
                        .addHeader("Authorization", "Bearer " + "SharePrefManager.getToken(context)")
                        .addHeader("Accept", "application/json")
                        .build()

                }else{
                    return null
                }

            }
            }).build()


    }


}