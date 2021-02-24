package com.joe.taipeijourney.APIInterface;

import com.joe.taipeijourney.value.ConstantValue;

import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: Joe Cheng
 */
public class RetrofitManager {

    private static RetrofitManager mInstance = new RetrofitManager();

    private APIInterface apiInterface;

    private RetrofitManager()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantValue.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiInterface = retrofit.create(APIInterface.class);
    }

    public static RetrofitManager getInstance()
    {
        return mInstance;
    }

    public APIInterface getApiInterface()
    {
        return apiInterface;
    }
}
