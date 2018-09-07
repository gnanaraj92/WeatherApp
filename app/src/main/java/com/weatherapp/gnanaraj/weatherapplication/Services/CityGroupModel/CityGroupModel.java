
package com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CityGroupModel {

    @SerializedName("cnt")
    private Long mCnt;
    @SerializedName("list")
    private java.util.List<com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel.List> mList;

    public Long getCnt() {
        return mCnt;
    }

    public void setCnt(Long cnt) {
        mCnt = cnt;
    }

    public java.util.List<com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel.List> getList() {
        return mList;
    }

    public void setList(java.util.List<com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel.List> list) {
        mList = list;
    }

}
