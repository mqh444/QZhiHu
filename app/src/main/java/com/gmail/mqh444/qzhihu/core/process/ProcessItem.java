package com.gmail.mqh444.qzhihu.core.process;

import com.gmail.mqh444.qzhihu.core.log.XLog;

/**
 * ProcessItem
 * Created by Louis on 2016/11/9.
 */

public class ProcessItem<P> {

    String key;

    IProcess<P> process;

    Class<IProcess<P>> processClass;

    boolean isNewInstance; // 是否单个实例运行

    public ProcessItem(String key){
        this.key = key;
    }

    public ProcessItem<P> setProcess(IProcess<P> process) {
        this.process = process;

        return this;
    }

    public ProcessItem<P> setProcess(Class<IProcess<P>> processClass,boolean isNewInstance){
        this.processClass = processClass;
        this.isNewInstance = isNewInstance;

        return this;
    }

    public void doProcess(P param){
        try{
            if (process != null){
                process.process(key,param);
            }else {
                if (processClass != null){
                    IProcess<P> temp = processClass.newInstance();
                    if (temp != null){
                        temp.process(key,param);
                    }

                    if (temp != null && !isNewInstance){
                        process = temp;
                    }
                }
            }
        }catch (Exception e){
            XLog.i("process key = %s, param = %s fail", key, param);
        }
    }
}
