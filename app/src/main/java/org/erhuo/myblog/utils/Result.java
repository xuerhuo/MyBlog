package org.erhuo.myblog.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by erhuo on 2017/4/21.
 */

public class Result{
    private String coookies;
    private String surl;
    public String sresult;
    private String sreturntype;
    public Map<String,List<String>> responseHeader;
    public JSONObject json;
    public Result(String sresult) {
        this.sresult=sresult;
    }
    public void getJson() throws JSONException {
        if(!this.sresult.isEmpty()){
            this.json=new JSONObject(this.sresult);
        }
    }
}
