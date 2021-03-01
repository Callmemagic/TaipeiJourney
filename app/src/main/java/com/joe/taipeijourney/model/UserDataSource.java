package com.joe.taipeijourney.model;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * author: Joe Cheng
 */
public interface UserDataSource {

    Completable insertRemark(String remark);

    Single<String> getRemarkById(String id);

}
