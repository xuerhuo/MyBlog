package org.erhuo.myblog.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by erhuo on 2017/4/25.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"receive broadcast",Toast.LENGTH_SHORT).show();
    }
}
