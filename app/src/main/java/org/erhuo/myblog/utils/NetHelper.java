package org.erhuo.myblog.utils;


import java.util.Map;
/**
 * Created by erhuo on 2017/4/20.
 */

public class NetHelper{
    public String url="";

    public NetHelper(String url, String method,Map param,int callmethod){
        this.url=url;
            Runnable r=new NetThread(url,method,param,this,callmethod);
            Thread t=new Thread(r);
            t.setDaemon(true);
            t.start();
    }
 //   public void success(BlogHttp blogHttp);
}
