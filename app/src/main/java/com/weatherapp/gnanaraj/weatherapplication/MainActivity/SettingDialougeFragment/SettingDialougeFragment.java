package com.weatherapp.gnanaraj.weatherapplication.MainActivity.SettingDialougeFragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.weatherapp.gnanaraj.weatherapplication.Base.BaseDialog;
import com.weatherapp.gnanaraj.weatherapplication.MainActivity.MainActivity;
import com.weatherapp.gnanaraj.weatherapplication.R;
import com.weatherapp.gnanaraj.weatherapplication.databinding.SettingLayoutBinding;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class SettingDialougeFragment extends BaseDialog implements SettingDialougeNavigator {

    private static final String TAG = SettingDialougeFragment.class.getSimpleName();

    @Inject
    SettingDialougeViewModule settingDialougeViewModule;

    static SettingDialougeFragment fragment;


    public static SettingDialougeFragment newInstance() {
       fragment = fragment==null?new SettingDialougeFragment():fragment;
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SettingLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.setting_layout, container, false);
        View view = binding.getRoot();
        AndroidSupportInjection.inject(this);
        binding.setViewModel(settingDialougeViewModule);
        getDialog().setCancelable(false);
        settingDialougeViewModule.setNavigator(this);
        binding.tempGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.celsius:
                        ((MainActivity)getActivity()).getViewModel().getNavigator().setCelsius();
                        dismissDialog(TAG);
                        break;
                    case R.id.fahrenheit:
                        ((MainActivity)getActivity()).getViewModel().getNavigator().setfahrenheit();
                        dismissDialog(TAG);
                        break;

                }
            }
        });
        return view;
    }


    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
    }
}
