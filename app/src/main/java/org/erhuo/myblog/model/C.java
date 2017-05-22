package org.erhuo.myblog.model;

/**
 * Created by erhuo on 2017/4/17.
 */

public class C {
    public static String host="erhuo.org";
    public static String site="http://"+host;
    public static String loginurl=site+"/admin/index/login/ajax/1";
    public static String geturl(String type){
        if(type.equals("login")){
            return C.loginurl;
        }
        return "false";
    }
}
