package com.joe.taipeijourney.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * author: Joe Cheng
 */
public class JourneyResultsBean implements Serializable {
    @SerializedName("_id")
    private String _id;

    @SerializedName("stitle")
    private String stitle;

    @SerializedName("MRT")
    private String MRT;

    @SerializedName("info")
    private String info;

    @SerializedName("xbody")
    private String xbody;

    @SerializedName("CAT1")
    private String cat1;

    @SerializedName("CAT2")
    private String cat2;

    @SerializedName("address")
    private String address;

    public String getStitle() {
        return stitle;
    }

    public String getInfo() {
        return info;
    }

    public String getXbody() {
        return xbody;
    }

    public String getCat1() {
        return cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public String getAddress() {
        return address;
    }

    public String getMRT() {
        return MRT;
    }

    public String getid() {
        return _id;
    }
}
