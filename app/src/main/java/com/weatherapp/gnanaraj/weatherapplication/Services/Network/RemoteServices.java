package com.weatherapp.gnanaraj.weatherapplication.Services.Network;

import android.os.RemoteException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.weatherapp.gnanaraj.weatherapplication.BuildConfig;
import com.weatherapp.gnanaraj.weatherapplication.Services.CityGroupModel.CityGroupModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.ForeCastModel.ForeCastModel;
import com.weatherapp.gnanaraj.weatherapplication.Services.LatLngModel.LatLngModel;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteServices {
    private static RemoteServices instance;

    private final Retrofit retrofit;


    public RemoteServices() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request().newBuilder()
                                .build();
                        return  chain.proceed(original);
                    }
                }).build();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class,new GsonUTCDateAdapter())
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static synchronized RemoteServices getInstance() {
        if (instance == null) {
            instance = new RemoteServices();
        }
        return instance;
    }

    public Call<LatLngModel> getCityWeatherLatLng(Map<String,String> options) throws IOException, RemoteException {
        RemoteEndPoint service = retrofit.create(RemoteEndPoint.class);
        // Remote call can be executed synchronously since the job calling it is already backgrounded.
        return service.getCityWeatherLatLng(options);
    }

    public Call<CityGroupModel> getGroupCityWeather(Map<String,String> options) throws IOException, RemoteException {
        RemoteEndPoint service = retrofit.create(RemoteEndPoint.class);
        // Remote call can be executed synchronously since the job calling it is already backgrounded.
        return service.getGroupCityWeather(options);
    }

    public Call<ForeCastModel> getForeCastWeather(Map<String,String> options) throws IOException, RemoteException {
        RemoteEndPoint service = retrofit.create(RemoteEndPoint.class);
        // Remote call can be executed synchronously since the job calling it is already backgrounded.
        return service.getForeCastWeather(options);
    }


}
