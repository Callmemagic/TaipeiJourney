package com.joe.taipeijourney.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.stetho.Stetho;
import com.joe.taipeijourney.R;
import com.joe.taipeijourney.database.Journey;
import com.joe.taipeijourney.database.JourneyDatabase;
import com.joe.taipeijourney.databinding.ActivityDetailBinding;
import com.joe.taipeijourney.model.JourneyResultsBean;
import com.joe.taipeijourney.presenter.DetailPresenter;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailActivity extends AppCompatActivity implements IDetailView{
    ActivityDetailBinding activityDetailBinding;
    DetailPresenter detailPresenter;
    Context context = DetailActivity.this;
    public static final String TAG = DetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Stetho.initializeWithDefaults(this);

        activityDetailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());

        detailPresenter = new DetailPresenter(this);
        detailPresenter.setResultBean((JourneyResultsBean) getIntent().getExtras().get("ITEM"));
        detailPresenter.getResultBean();
    }

    @Override
    public void setViews(JourneyResultsBean bean) {
        activityDetailBinding.tvStitle.setText(bean.getStitle());
        activityDetailBinding.tvTag.setText(String.format(getResources().getString(R.string.tag),
                bean.getCat1() + "," + bean.getCat2()));
        activityDetailBinding.tvAddress.setText(String.format(getResources().getString(R.string.address),
                bean.getAddress()));
        activityDetailBinding.tvMRT.setText(String.format(getResources().getString(R.string.MRT),
                bean.getMRT()));
        activityDetailBinding.tvTraffic.setText(String.format(getResources().getString(R.string.traffic),
                bean.getInfo()));
        activityDetailBinding.tvInfo.setText(String.format(getResources().getString(R.string.info),
                bean.getXbody()));

        activityDetailBinding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailPresenter.saveRemark(context, bean.getid(), activityDetailBinding.etRemark.getText().toString());
                Toast.makeText(context, getString(R.string.saved),Toast.LENGTH_SHORT).show();
            }
        });

//        JourneyDatabase.getInstance(context).journeyDao().getRemark(bean.getid())
        detailPresenter.getRemark(context, bean.getid())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Journey>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Journey journey) {
                        Log.d(TAG, "onSuccess: ");
                        activityDetailBinding.etRemark.setText(journey.getRemark());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }
                });
    }
}