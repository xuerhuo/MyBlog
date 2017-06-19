package org.erhuo.myblog.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.erhuo.myblog.R;

/**
 * Created by erhuo on 2017/4/25.
 * 课堂练习
 */

public class CindexActivity extends Activity implements View.OnClickListener{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cindex);
        Button btn=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(this);
        Button btn2=(Button)findViewById(R.id.startservice);
        btn2.setOnClickListener(this);
        Button stopservice=(Button)findViewById(R.id.stopservice);
        stopservice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("action","inclicklistenner");
        switch (v.getId()) {
            case R.id.button2:
                Intent intent=new Intent();
                intent.setAction("sendbroadcast");
                CindexActivity.this.sendBroadcast(intent);
                Toast.makeText(this,"sended boradcast",Toast.LENGTH_SHORT).show();
                break;
            case R.id.startservice:
                Toast.makeText(this,"servicebtnclick",Toast.LENGTH_SHORT).show();
                Intent intentservice=new Intent();
                intentservice.setAction("MyService");
                startService(intentservice);
                break;
            case R.id.stopservice:
                Intent stopservice=new Intent();
                stopservice.setAction("MyService");
                stopService(stopservice);
                break;
        }
    }
}
