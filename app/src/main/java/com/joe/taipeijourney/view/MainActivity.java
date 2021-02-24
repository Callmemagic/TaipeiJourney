package com.joe.taipeijourney.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.joe.taipeijourney.adapter.JourneyInfoListAdapter;
import com.joe.taipeijourney.databinding.ActivityMainBinding;
import com.joe.taipeijourney.model.JourneyInfo;
import com.joe.taipeijourney.presenter.JourneyPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IMainView{
    public static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding activityMainBinding;
    private JourneyPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        presenter = new JourneyPresenter(this);

        activityMainBinding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //查詢API
                presenter.getAllResult(activityMainBinding.etKeyword.getText().toString(),
                        activityMainBinding.etLimit.getText().toString(), "");

            }
        });
    }

    @Override
    public void onSuccess(JourneyInfo info) {
        Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
        JourneyInfoListAdapter journeyInfoListAdapter = new JourneyInfoListAdapter(MainActivity.this, info.getBeans().getResults());
        activityMainBinding.rvResult.setAdapter(journeyInfoListAdapter);
        activityMainBinding.rvResult.setHasFixedSize(true);
        activityMainBinding.rvResult.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    public void onError(String error) {
        //網路錯誤
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
    }
}