package com.gmail.mqh444.qzhihu.core.process;

/**
 * IProcess
 * Created by Louis on 2016/11/9.
 */

public interface IProcess<P> {

    void process(String key, P param);

}
