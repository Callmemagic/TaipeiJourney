package com.joe.taipeijourney.view;

import com.joe.taipeijourney.model.JourneyInfo;

/**
 * author: Joe Cheng
 */
public interface IMainView {
    void onSuccess(JourneyInfo info);

    void onError(String error);
}
