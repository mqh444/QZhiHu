package com.gmail.mqh444.qzhihu.business.api.impl.retrofit;

import com.gmail.mqh444.qzhihu.core.net.NetWorkException;

/**
 * RetrofitAdapter
 * Created by Louis on 2016/11/10.
 */

public abstract class RetrofitAdapter<T> {

    abstract T call() throws Exception;

    protected T get() throws NetWorkException{
        T t;
        try{
            t = call();
        }catch (Exception e){
            throw new NetWorkException(e);
        }
        return t;
    }
}
