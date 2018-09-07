
package com.weatherapp.gnanaraj.weatherapplication.Services.ForeCastModel;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Main {

    @SerializedName("grnd_level")
    private Double mGrndLevel;
    @SerializedName("humidity")
    private Long mHumidity;
    @SerializedName("pressure")
    private Double mPressure;
    @SerializedName("sea_level")
    private Double mSeaLevel;
    @SerializedName("temp")
    private Double mTemp;
    @SerializedName("temp_kf")
    private Double mTempKf;
    @SerializedName("temp_max")
    private Double mTempMax;
    @SerializedName("temp_min")
    private Double mTempMin;

    public Double getGrndLevel() {
        return mGrndLevel;
    }

    public void setGrndLevel(Double grndLevel) {
        mGrndLevel = grndLevel;
    }

    public Long getHumidity() {
        return mHumidity;
    }

    public void setHumidity(Long humidity) {
        mHumidity = humidity;
    }

    public Double getPressure() {
        return mPressure;
    }

    public void setPressure(Double pressure) {
        mPressure = pressure;
    }

    public Double getSeaLevel() {
        return mSeaLevel;
    }

    public void setSeaLevel(Double seaLevel) {
        mSeaLevel = seaLevel;
    }

    public Double getTemp() {
        return mTemp;
    }

    public void setTemp(Double temp) {
        mTemp = temp;
    }

    public Double getTempKf() {
        return mTempKf;
    }

    public void setTempKf(Double tempKf) {
        mTempKf = tempKf;
    }

    public Double getTempMax() {
        return mTempMax;
    }

    public void setTempMax(Double tempMax) {
        mTempMax = tempMax;
    }

    public Double getTempMin() {
        return mTempMin;
    }

    public void setTempMin(Double tempMin) {
        mTempMin = tempMin;
    }

}
