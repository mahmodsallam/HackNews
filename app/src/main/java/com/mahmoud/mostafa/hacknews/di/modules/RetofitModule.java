package com.mahmoud.mostafa.hacknews.di.modules;

import com.mahmoud.mostafa.hacknews.utils.ApiEndpoints;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@Singleton
public class RetofitModule {

    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit
                .Builder()
                .baseUrl(ApiEndpoints.BASE_URl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    public OkHttpClient getHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient().newBuilder().addInterceptor(interceptor).build();
    }

    @Provides
    public HttpLoggingInterceptor getLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
