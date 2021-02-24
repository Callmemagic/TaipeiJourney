package com.joe.taipeijourney.model;

import com.google.gson.annotations.SerializedName;

/**
 * author: Joe Cheng
 */
public class JourneyResultsBean{
    @SerializedName("stitle")
    private String stitle;

    @SerializedName("info")
    private String info;

    @SerializedName("xbody")
    private String xbody;

    public String getStitle() {
        return stitle;
    }

    public String getInfo() {
        return info;
    }

    public String getXbody() {
        return xbody;
    }
}
