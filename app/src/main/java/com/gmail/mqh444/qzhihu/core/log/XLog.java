package com.gmail.mqh444.qzhihu.core.log;


import android.util.Log;
import android.util.Range;

/**
 * XLog
 * Created by Louis on 2016/11/8.
 */

public class XLog {

    private static final String Q_ZHIHU = "QZhiHu";

    public static int v(String msg, Object... args){
        String msgLocal = msg;
        if (args != null && args.length != 0){
            msgLocal = String.format(msg, args);
        }
        return Log.v(Q_ZHIHU, msgLocal);
    }

    public static int d(String msg, Object... args){
        String msgLocal = msg;
        if (args != null && args.length != 0){
            msgLocal = String.format(msg, args);
        }
        return Log.d(Q_ZHIHU,msgLocal);
    }

    public static int i(String msg, Object... args){
        String msgLocal = msg;
        if (args != null && args.length != 0){
            msgLocal = String.format(msg,args);
        }
        return Log.i(Q_ZHIHU,msgLocal);
    }

    public static int w(String tr){
        return Log.w(Q_ZHIHU,tr);
    }

    public static int e(String msg,Object... args){
        String msgLocal = msg;
        if (args != null && args.length != 0){
            msgLocal = String.format(msg,args);
        }
        return Log.e(Q_ZHIHU,msgLocal);
    }

    public static int e(String msg, Throwable tr){
        return Log.e(Q_ZHIHU,msg,tr);
    }

    private XLog(){}

}
