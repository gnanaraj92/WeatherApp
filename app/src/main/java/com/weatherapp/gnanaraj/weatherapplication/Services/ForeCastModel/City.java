
package com.weatherapp.gnanaraj.weatherapplication.Services.ForeCastModel;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class City {

    @SerializedName("coord")
    private Coord mCoord;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;

    public Coord getCoord() {
        return mCoord;
    }

    public void setCoord(Coord coord) {
        mCoord = coord;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
