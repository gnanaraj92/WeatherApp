
package com.weatherapp.gnanaraj.weatherapplication.Services.ForeCastModel;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Wind {

    @SerializedName("deg")
    private Double mDeg;
    @SerializedName("speed")
    private Double mSpeed;

    public Double getDeg() {
        return mDeg;
    }

    public void setDeg(Double deg) {
        mDeg = deg;
    }

    public Double getSpeed() {
        return mSpeed;
    }

    public void setSpeed(Double speed) {
        mSpeed = speed;
    }

}
