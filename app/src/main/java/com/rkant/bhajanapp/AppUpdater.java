package com.rkant.bhajanapp;

import static android.content.Context.DOWNLOAD_SERVICE;
import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AppUpdater {
    MainActivity mainActivity;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObject;
    Context context;

    int versionCodeOfApp=MainActivity.versionCodeOfApp;
    public AppUpdater(Context contex, MainActivity mainActivity) {
        this.mainActivity=mainActivity;
        this.context=contex;
    }
   String url_version_code ="https://check-version-number-axvy.shuttle.app/route/version/1";
   String url_app_link="https://check-version-number-axvy.shuttle.app/route/1";

//       int

    public void downloadFile(){
        DownloadManager downloadManager= (DownloadManager) context.getSystemService(DOWNLOAD_SERVICE);

        Uri uri=Uri.parse(url_app_link);
        DownloadManager.Request request=new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "app-release.apk");
        request.setTitle("app-release.apk");
        request.setDescription("Downloading file...");
        downloadManager.enqueue(request);

    }

    public void usingVolley(){
        requestQueue= Volley.newRequestQueue(context);
        jsonObject=new JsonObjectRequest(Request.Method.GET, url_version_code, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject json) {


                try {
                    int i =json.getInt("version_number_id");
                    Toast.makeText(context, ""+versionCodeOfApp, Toast.LENGTH_SHORT).show();

                    if(i>versionCodeOfApp){
                        downloadFile();
                    }else{
                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Failed fetching data", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObject);
    }

    public boolean checkStoragePermission() {
        // For Android 6.0 and above, we need to request runtime permission

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // Android 11 (API 30) and above
            if (Environment.isExternalStorageManager()) {
                // Permission already granted
                return true;

            } else {
                // Request the permission
                Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);

                mainActivity.startActivityForResult(intent, 100);

            }
        } else {
            // For Android 10 and below
            if (ContextCompat.checkSelfPermission(context,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(context,
                            android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                // Permissions already granted
                return true;
//
            } else {
                // Request permissions
                ActivityCompat.requestPermissions(mainActivity,
                        new String[]{
                                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        },
                        100);
            }
        }
        return false;
    }



}
