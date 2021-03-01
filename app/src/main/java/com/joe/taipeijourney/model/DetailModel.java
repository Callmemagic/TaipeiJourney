package com.joe.taipeijourney.model;

import android.content.Context;

import com.joe.taipeijourney.database.Journey;
import com.joe.taipeijourney.database.JourneyDao;
import com.joe.taipeijourney.database.JourneyDatabase;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * author: Joe Cheng
 */
public class DetailModel implements IDetailModel{
    JourneyResultsBean bean;
    @Override
    public void setJsonBean(JourneyResultsBean bean) {
        this.bean = bean;
    }

    @Override
    public JourneyResultsBean getJsonBean() {
        return bean;
    }

    @Override
    public void saveRemark(Context context, String id, String remark) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                JourneyDatabase.getInstance(context).journeyDao()
                        .insert(new Journey(id, remark));
            }
        }).start();
    }

    @Override
    public Single<Journey> getRemark(Context context, String id) {
        return JourneyDatabase.getInstance(context).journeyDao().getRemark(id);
    }
}
