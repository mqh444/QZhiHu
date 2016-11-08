package com.gmail.mqh444.qzhihu.core.net;

/**
 * NetWorkException
 * Created by Louis on 2016/11/8.
 */

public class NetWorkException extends Throwable {

    private final Throwable detailThrowable;

    public NetWorkException(Throwable throwable){
        super(throwable);
        this.detailThrowable = throwable;
    }

    public Throwable getDetailThrowable(){
        return detailThrowable;
    }

    @Override
    public String toString() {
        return "NetWorkException{" +
                "detailThrowable=" + detailThrowable +
                '}';
    }
}
