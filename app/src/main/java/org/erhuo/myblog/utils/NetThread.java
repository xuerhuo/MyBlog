package org.erhuo.myblog.utils;

import android.os.Message;

import org.erhuo.myblog.controller.LoginActivity;

import java.util.Map;
import java.util.SimpleTimeZone;

/**
 * Created by erhuo on 2017/4/20.
 */

public class NetThread implements Runnable {
    public String url="";
    public String mmethod="";
    public Map mmap;
    public NetHelper mnetHelper;
    public int callmethod;
    public NetThread(String url, String method, Map param,NetHelper netHelper,int scall){
        this.url=url;
        this.mmethod=method;
        this.mmap=param;
        this.mnetHelper=netHelper;
        this.callmethod=scall;
    }
    public void run(){
        BlogHttp blogHttp=new BlogHttp(this.url);
        if(this.mmethod.equals("get")){
            blogHttp.sendGet();
        }else if(this.mmethod=="post"){
            blogHttp.post(this.mmap);
        }
        Message msg = new Message();
        // 消息对象可以携带数据
        Result res=new Result(blogHttp.sresult);
        msg.obj = res;
        msg.what = this.callmethod;
        LoginActivity.mhandler.sendMessage(msg);
        //this.mnetHelper.success(blogHttp);
    }
}
