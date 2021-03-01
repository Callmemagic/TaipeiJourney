package com.joe.taipeijourney.presenter;

import android.util.Log;

import com.joe.taipeijourney.APIInterface.APIInterface;
import com.joe.taipeijourney.APIInterface.RetrofitManager;
import com.joe.taipeijourney.model.JourneyInfo;
import com.joe.taipeijourney.view.IMainView;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author: Joe Cheng
 */
public class JourneyPresenter {
    private IMainView mMainView;

    private JourneyInfo journeyInfo;

    public JourneyPresenter(IMainView view)
    {
        this.mMainView = view;
    }

    public void getAllResult(String keyword, String limit, String offset)
    {
        //查詢API
        APIInterface apiInterface = RetrofitManager.getInstance().getApiInterface();
        apiInterface.getJourneyInfo("resourceAquire", keyword, limit, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JourneyInfo>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull JourneyInfo info) {
                        journeyInfo = info;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mMainView.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        if(journeyInfo != null)
                        {
                            mMainView.onSuccess(journeyInfo);
                        }
                    }
                });
    }
}
