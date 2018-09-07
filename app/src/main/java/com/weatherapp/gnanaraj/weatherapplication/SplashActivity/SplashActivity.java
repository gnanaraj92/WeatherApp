package com.weatherapp.gnanaraj.weatherapplication.SplashActivity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.weatherapp.gnanaraj.weatherapplication.BR;
import com.weatherapp.gnanaraj.weatherapplication.Base.BaseActivity;
import com.weatherapp.gnanaraj.weatherapplication.MainActivity.MainActivity;
import com.weatherapp.gnanaraj.weatherapplication.R;
import com.weatherapp.gnanaraj.weatherapplication.databinding.ActivitySplashBinding;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashActivityViewModel> implements  SplashNavigator{

    ActivitySplashBinding mActivitySplashBinding;

    @Inject
    SplashActivityViewModel mSplashActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitySplashBinding=getViewDataBinding();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getViewModel().LoadSettings();
                finish();
                startActivity(MainActivity.getStartIntent(SplashActivity.this));
            }
        },5300);
    }

    @Override
    public SplashActivityViewModel getViewModel() {
        return mSplashActivityViewModel;
    }

    @Override
    public void setup() {

    }

    @Override
    public int getBindingVariable() {
        return BR.SplashViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }
}
