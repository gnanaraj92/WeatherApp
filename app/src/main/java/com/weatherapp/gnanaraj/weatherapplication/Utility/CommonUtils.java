package com.weatherapp.gnanaraj.weatherapplication.Utility;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.Settings;

import com.weatherapp.gnanaraj.weatherapplication.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommonUtils {
    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    @SuppressLint("all")
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public final static String getCurrentMonth(long timestamp) {
        SimpleDateFormat df=new SimpleDateFormat(Constants.STR_MONTH_LOWER_CASE);
        return df.format(timestamp);
    }

    public final static String getCurrentDate(long timestamp) {
        SimpleDateFormat df=new SimpleDateFormat(Constants.TIME_STAMP_FORMAT_D_M_Y);
        return df.format(timestamp*1000);
    }
}
