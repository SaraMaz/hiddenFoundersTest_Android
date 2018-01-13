package com.mazouzi.trendingRepos;

import android.app.Application;
import android.content.Context;

// it gives us the possibility to get the application context from any other class
public class MyApp extends Application {
    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}