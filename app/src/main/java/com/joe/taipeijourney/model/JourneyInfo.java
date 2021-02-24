package com.joe.taipeijourney.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * author: Joe Cheng
 */
public class JourneyInfo {
    @SerializedName("result")
    private JourneyResultBean beans;

    public JourneyResultBean getBeans() {
        return beans;
    }
}
