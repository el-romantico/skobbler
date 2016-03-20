package com.skobbler.sdkdemo.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;

import com.skobbler.ngx.SKDeveloperKeyException;
import com.skobbler.ngx.SKMaps;
import com.skobbler.ngx.SKMapsInitSettings;
import com.skobbler.ngx.map.SKAnnotation;
import com.skobbler.ngx.map.SKCoordinateRegion;
import com.skobbler.ngx.map.SKMapCustomPOI;
import com.skobbler.ngx.map.SKMapPOI;
import com.skobbler.ngx.map.SKMapSurfaceListener;
import com.skobbler.ngx.map.SKMapViewHolder;
import com.skobbler.ngx.map.SKMapViewStyle;
import com.skobbler.ngx.map.SKPOICluster;
import com.skobbler.ngx.map.SKScreenPoint;
import com.skobbler.ngx.navigation.SKAdvisorSettings;
import com.skobbler.sdkdemo.R;
import com.skobbler.sdkdemo.application.DemoApplication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MapActivity extends Activity {

    public static final long KILO = 1024;

    public static final long MEGA = KILO * KILO;

    private SKMapViewHolder mapViewGroup;

    public static long getAvailableMemorySize(String path) {
        StatFs statFs = null;
        try {
            statFs = new StatFs(path);
        } catch (IllegalArgumentException ex) {
        }
        if (statFs != null) {
            Method getAvailableBytesMethod = null;
            try {
                getAvailableBytesMethod = statFs.getClass().getMethod("getAvailableBytes");
            } catch (NoSuchMethodException e) {
            }

            if (getAvailableBytesMethod != null) {
                try {
                    return (Long) getAvailableBytesMethod.invoke(statFs);
                } catch (IllegalAccessException e) {
                    return (long) statFs.getAvailableBlocks() * (long) statFs.getBlockSize();
                } catch (InvocationTargetException e) {
                    return (long) statFs.getAvailableBlocks() * (long) statFs.getBlockSize();
                }
            } else {
                return (long) statFs.getAvailableBlocks() * (long) statFs.getBlockSize();
            }
        } else {
            return 0;
        }
    }

    public static String chooseStoragePath(Context context) {
        if (getAvailableMemorySize(Environment.getDataDirectory().getPath()) >= 50 * MEGA) {
            if (context != null && context.getFilesDir() != null) {
                return context.getFilesDir().getPath();
            }
        } else {
            if ((context != null) && (context.getExternalFilesDir(null) != null)) {
                if (getAvailableMemorySize(context.getExternalFilesDir(null).toString()) >= 50 * MEGA) {
                    return context.getExternalFilesDir(null).toString();
                }
            }
        }


        if (context != null && context.getFilesDir() != null) {
            return context.getFilesDir().getPath();
        } else {
            if ((context != null) && (context.getExternalFilesDir(null) != null)) {
                return context.getExternalFilesDir(null).toString();
            } else {
                return null;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SKMapsInitSettings initMapSettings = new SKMapsInitSettings();

        String applicationPath = chooseStoragePath(this);

        String mapResourcesDirPath = "";

        // determine path where map resources should be copied on the device
        if (applicationPath != null) {
            mapResourcesDirPath = applicationPath + "/" + "SKMaps/";
        } else {
            // show a dialog and then finish
        }

        //final String  mapResourcesPath = ((DemoApplication)this.getApplicationContext()).getAppPrefs().getStringPreference("mapResourcesPath");
        //initMapSettings.setMapResourcesPaths(mapResourcesPath,
        //        new SKMapViewStyle(mapResourcesPath + "grayscalestyle/", "grayscalestyle.json"));

     //   final SKAdvisorSettings advisorSettings = initMapSettings.getAdvisorSettings();
        //advisorSettings.setAdvisorConfigPath(mapResourcesPath + "/Advisor");
        //advisorSettings.setResourcePath(mapResourcesPath + "/Advisor/Languages");
//        advisorSettings.setLanguage(SKAdvisorSettings.SKAdvisorLanguage.LANGUAGE_EN);
  //      advisorSettings.setAdvisorVoice("en");
   //     initMapSettings.setAdvisorSettings(advisorSettings);


        initMapSettings.setPreinstalledMapsPath("/sdcard/maps");
        initMapSettings.setConnectivityMode(SKMaps.CONNECTIVITY_MODE_OFFLINE);

        try {
            SKMaps.getInstance().initializeSKMaps(this, initMapSettings);
        }catch (SKDeveloperKeyException exception){
            exception.printStackTrace();
        }

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_map);

        mapViewGroup = (SKMapViewHolder) findViewById(R.id.view_group_map);
        mapViewGroup.setMapSurfaceListener(new SKMapSurfaceListener() {
            @Override
            public void onActionPan() {

            }

            @Override
            public void onActionZoom() {

            }

            @Override
            public void onSurfaceCreated(SKMapViewHolder skMapViewHolder) {
            }

            @Override
            public void onMapRegionChanged(SKCoordinateRegion skCoordinateRegion) {

            }

            @Override
            public void onMapRegionChangeStarted(SKCoordinateRegion skCoordinateRegion) {

            }

            @Override
            public void onMapRegionChangeEnded(SKCoordinateRegion skCoordinateRegion) {

            }

            @Override
            public void onDoubleTap(SKScreenPoint skScreenPoint) {

            }

            @Override
            public void onSingleTap(SKScreenPoint skScreenPoint) {

            }

            @Override
            public void onRotateMap() {

            }

            @Override
            public void onLongPress(SKScreenPoint skScreenPoint) {

            }

            @Override
            public void onInternetConnectionNeeded() {

            }

            @Override
            public void onMapActionDown(SKScreenPoint skScreenPoint) {

            }

            @Override
            public void onMapActionUp(SKScreenPoint skScreenPoint) {

            }

            @Override
            public void onPOIClusterSelected(SKPOICluster skpoiCluster) {

            }

            @Override
            public void onMapPOISelected(SKMapPOI skMapPOI) {

            }

            @Override
            public void onAnnotationSelected(SKAnnotation skAnnotation) {

            }

            @Override
            public void onCustomPOISelected(SKMapCustomPOI skMapCustomPOI) {

            }

            @Override
            public void onCompassSelected() {

            }

            @Override
            public void onCurrentPositionSelected() {

            }

            @Override
            public void onObjectSelected(int i) {

            }

            @Override
            public void onInternationalisationCalled(int i) {

            }

            @Override
            public void onBoundingBoxImageRendered(int i) {

            }

            @Override
            public void onGLInitializationError(String s) {

            }

            @Override
            public void onScreenshotReady(Bitmap bitmap) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapViewGroup.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapViewGroup.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SKMaps.getInstance().destroySKMaps();
    }
}