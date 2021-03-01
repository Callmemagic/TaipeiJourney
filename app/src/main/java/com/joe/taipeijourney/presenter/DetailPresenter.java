package com.joe.taipeijourney.presenter;

import android.content.Context;

import com.joe.taipeijourney.database.Journey;
import com.joe.taipeijourney.database.JourneyDatabase;
import com.joe.taipeijourney.model.DetailModel;
import com.joe.taipeijourney.model.IDetailModel;
import com.joe.taipeijourney.model.JourneyResultsBean;
import com.joe.taipeijourney.view.IDetailView;

import io.reactivex.Single;

/**
 * author: Joe Cheng
 */
public class DetailPresenter {
    private IDetailView iDetailView;
    private IDetailModel iDetailModel;

    public DetailPresenter(IDetailView iDetailView) {
        this.iDetailView = iDetailView;
        iDetailModel = new DetailModel();
    }

    public void setResultBean(JourneyResultsBean bean)
    {
        iDetailModel.setJsonBean(bean);
    }

    public void getResultBean()
    {
        iDetailView.setViews(iDetailModel.getJsonBean());
    }

    public void saveRemark(Context context, String id, String remark)
    {
        iDetailModel.saveRemark(context, id, remark);
    }

    public Single<Journey> getRemark(Context context, String id)
    {
        return iDetailModel.getRemark(context, id);
    }
}
