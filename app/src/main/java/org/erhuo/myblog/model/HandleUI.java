package org.erhuo.myblog.model;

import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import org.erhuo.myblog.controller.CindexActivity;
import org.erhuo.myblog.controller.LoginActivity;
import org.erhuo.myblog.utils.Result;
import org.json.JSONException;

import static org.erhuo.myblog.controller.LoginActivity.context;

/**
 * Created by erhuo on 2017/4/25.
 */

public class HandleUI {
    private Handler mhandler;
    public void messageHandler(){
        this.mhandler=new Handler() {
            public void handleMessage(android.os.Message msg) {
                if(msg.what==BlogModel.mstate.LOGIN.ordinal()){
                    Result res= (Result) msg.obj;
                    try {
                        res.getJson();
                        if(res.json.getBoolean("status")==true){
                            Toast.makeText(context,BlogLang.login_success,Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(LoginActivity.this,CindexActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(context,BlogLang.login_fail,Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}
