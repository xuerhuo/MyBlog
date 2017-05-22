package org.erhuo.myblog.controller;
import org.erhuo.myblog.R;
import org.erhuo.myblog.model.BlogLang;
import org.erhuo.myblog.model.BlogModel;
import org.erhuo.myblog.model.C;
import org.erhuo.myblog.utils.Result;
import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.*;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;
import org.erhuo.myblog.*;
import java.io.IOException;

public class LoginActivity extends Activity implements OnClickListener {
	public static Context context;
	public static Handler mhandler;
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);  //无title
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		findViewById(R.id.loginbutton).setOnClickListener(this);
		this.context=this;
		this.messageHandler();
    }
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.loginbutton:
				//Toast.makeText(context,BlogLang.logining,Toast.LENGTH_SHORT).show();
				EditText username=(EditText)findViewById(R.id.username);
				String susername=username.getText().toString();
				EditText password=(EditText)findViewById(R.id.password);
				String spassword=password.getText().toString();
                BlogModel blog=new BlogModel();
				try {
					blog.login(susername,spassword);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
				break;
			default:
				break;
		}
	}

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
