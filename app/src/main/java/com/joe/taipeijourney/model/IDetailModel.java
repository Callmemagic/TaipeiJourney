package com.joe.taipeijourney.model;

import android.content.Context;

import com.joe.taipeijourney.database.Journey;

import io.reactivex.Single;

/**
 * author: Joe Cheng
 */
public interface IDetailModel {
    void setJsonBean(JourneyResultsBean bean);

    JourneyResultsBean getJsonBean();

    void saveRemark(Context context, String id, String remark);

    Single<Journey> getRemark(Context context, String id);
}
