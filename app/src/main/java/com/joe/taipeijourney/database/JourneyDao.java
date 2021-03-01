package com.joe.taipeijourney.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.joe.taipeijourney.model.IDetailModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * author: Joe Cheng
 */
@Dao
public interface JourneyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Journey journey);

    @Query("select * from Journey where id = :id")
    Single<Journey> getRemark(String id);
}
