package com.joe.taipeijourney.APIInterface;

import com.joe.taipeijourney.model.JourneyInfo;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author: Joe Cheng
 */

//https://data.taipei/api/v1/dataset/36847f3f-deff-4183-a5bb-800737591de5?scope=resourceAquire&q&limit=2&offset
public interface APIInterface {
    //寫所有連線的地方，定義func()，實作交給別人
//    @GET("36847f3f-deff-4183-a5bb-800737591de5?scope=resourceAquire&q&limit=2&offset")
    @GET("36847f3f-deff-4183-a5bb-800737591de5")
    Observable<JourneyInfo> getJourneyInfo(@Query("scope") String scope,
                                           @Query("q") String keyword,
                                           @Query("limit") String limit,
                                           @Query("offset") String offset);


}
