package com.example.qyy.qyymvvm.net;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public class NetSingleHelper {
    private NetService netService;

    private NetSingleHelper() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new HttpLoggingInterceptor().setLevel(BODY))
                .retryOnConnectionFailure(true)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);

        String basrUrl = "http://stage.wx-api.kuaijiankang.cn:80/";
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(basrUrl)
                .build();
        netService = retrofit.create(NetService.class);
    }

    public static NetService getNetService() {
        return SingleHepler.NETHEPLER.netService;
    }

    private static class SingleHepler {
        private static final NetSingleHelper NETHEPLER = new NetSingleHelper();
    }
}
