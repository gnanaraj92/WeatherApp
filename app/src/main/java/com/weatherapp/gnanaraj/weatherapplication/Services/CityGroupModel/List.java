
package com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class List {

    @SerializedName("clouds")
    private Clouds mClouds;
    @SerializedName("coord")
    private Coord mCoord;
    @SerializedName("dt")
    private Long mDt;
    @SerializedName("id")
    private Long mId;
    @SerializedName("main")
    private Main mMain;
    @SerializedName("name")
    private String mName;
    @SerializedName("sys")
    private Sys mSys;
    @SerializedName("visibility")
    private Long mVisibility;
    @SerializedName("weather")
    private java.util.List<Weather> mWeather;
    @SerializedName("wind")
    private Wind mWind;

    public Clouds getClouds() {
        return mClouds;
    }

    public void setClouds(Clouds clouds) {
        mClouds = clouds;
    }

    public Coord getCoord() {
        return mCoord;
    }

    public void setCoord(Coord coord) {
        mCoord = coord;
    }

    public Long getDt() {
        return mDt;
    }

    public void setDt(Long dt) {
        mDt = dt;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Main getMain() {
        return mMain;
    }

    public void setMain(Main main) {
        mMain = main;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Sys getSys() {
        return mSys;
    }

    public void setSys(Sys sys) {
        mSys = sys;
    }

    public Long getVisibility() {
        return mVisibility;
    }

    public void setVisibility(Long visibility) {
        mVisibility = visibility;
    }

    public java.util.List<Weather> getWeather() {
        return mWeather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        mWeather = weather;
    }

    public Wind getWind() {
        return mWind;
    }

    public void setWind(Wind wind) {
        mWind = wind;
    }

}
