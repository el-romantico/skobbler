package com.skobbler.sdkdemo.application;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Tudor on 12/5/2014.
 */
public class ApplicationPreferences {

    /**
     * preference name
     */
    public static final String PREFS_NAME = "demoAppPrefs";

    /**
     * reference to preference
     */
    private SharedPreferences prefs;


    public ApplicationPreferences(Context context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public String getStringPreference(String key) {
        return prefs.getString(key, "");
    }
}
