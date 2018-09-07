
package com.weatherapp.gnanaraj.weatherapplication.Services.ForeCastModel;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Temp {

    @SerializedName("day")
    private Double mDay;
    @SerializedName("eve")
    private Double mEve;
    @SerializedName("max")
    private Double mMax;
    @SerializedName("min")
    private Double mMin;
    @SerializedName("morn")
    private Double mMorn;
    @SerializedName("night")
    private Double mNight;

    public Double getDay() {
        return mDay;
    }

    public void setDay(Double day) {
        mDay = day;
    }

    public Double getEve() {
        return mEve;
    }

    public void setEve(Double eve) {
        mEve = eve;
    }

    public Double getMax() {
        return mMax;
    }

    public void setMax(Double max) {
        mMax = max;
    }

    public Double getMin() {
        return mMin;
    }

    public void setMin(Double min) {
        mMin = min;
    }

    public Double getMorn() {
        return mMorn;
    }

    public void setMorn(Double morn) {
        mMorn = morn;
    }

    public Double getNight() {
        return mNight;
    }

    public void setNight(Double night) {
        mNight = night;
    }

}
