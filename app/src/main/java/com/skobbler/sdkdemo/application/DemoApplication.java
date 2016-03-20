package com.skobbler.sdkdemo.application;


import android.app.Application;

/**
 * Class that stores global application state
 */
public class DemoApplication extends Application {

    /**
     * Object for accessing application preferences
     */
    private ApplicationPreferences appPrefs;

    @Override
    public void onCreate() {
        super.onCreate();
        appPrefs = new ApplicationPreferences(this);
    }

    public ApplicationPreferences getAppPrefs() {
        return appPrefs;
    }
}
