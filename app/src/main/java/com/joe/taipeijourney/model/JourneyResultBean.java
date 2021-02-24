package com.joe.taipeijourney.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * author: Joe Cheng
 */
public class JourneyResultBean {
    @SerializedName("results")
    private ArrayList<JourneyResultsBean> results;

    public ArrayList<JourneyResultsBean> getResults() {
        return results;
    }
}
