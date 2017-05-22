package org.erhuo.myblog.controller;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by erhuo on 2017/4/25.
 */

public class MyService extends Service{
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();
    }
    public void onDestroy(){
        super.onDestroy();
        Log.d("service","stop service");
    }
    public void onStart(Intent context,int i){
        super.onStart(context,i);
       // Toast.makeText(,"startservice",Toast.LENGTH_SHORT).show();
        Log.d("service","start service");
    }
}
