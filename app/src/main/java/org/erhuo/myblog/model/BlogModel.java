package org.erhuo.myblog.model;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import org.erhuo.myblog.*;
import org.erhuo.myblog.controller.LoginActivity;
import org.erhuo.myblog.utils.BlogHttp;
import org.erhuo.myblog.utils.NetHelper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.erhuo.myblog.model.C;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;
import static org.erhuo.myblog.model.C.host;

/**
 * Created by erhuo on 2017/4/17.
 */

public class BlogModel extends LoginActivity{
    public String mresult;
    public JSONObject jsonresult;
    public enum mstate {
        LOGIN
    };

    public BlogModel(){
        mresult=null;
    }
    public void login(String username, String password) throws IOException, JSONException {
        Map<String,String> senddata=new HashMap<String,String>();
        senddata.put("username",username);
        senddata.put("password",password);
        NetHelper netHelper=new NetHelper(C.loginurl,"post", senddata,mstate.LOGIN.ordinal());
    }
}
