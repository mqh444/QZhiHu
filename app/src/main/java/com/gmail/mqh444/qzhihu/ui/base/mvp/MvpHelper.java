package com.gmail.mqh444.qzhihu.ui.base.mvp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * MvpHelper
 * Created by Louis on 2016/11/11.
 */

public class MvpHelper<P extends BaseMvpPresenter, V extends IMvpView> {

    Object target;

    public MvpHelper(Object target) {
        this.target = target;
    }

    /**
     * 返回实现{@link P}的class, 子类没有实现则为null
     */
    public Class<P> getPresenterClass(){
        Class<P> pClass = null;

        do {
            Type genType = target.getClass().getGenericSuperclass();
            if (!(genType instanceof ParameterizedType)){
                break;
            }
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if (params == null || params.length < 1){
                break;
            }
            if (params[0] != null && params[0] instanceof Class){
                pClass = (Class<P>) params[0];
            }
        }while (false);
        return pClass;
    }

    /**
     * 返回实现{@link V}的class, 子类没有实现则为null
     */
    public Class<V> getViewClass(){
        Class<V> vClass = null;

        do {
            Type genType = target.getClass().getGenericSuperclass();
            if (!(genType instanceof ParameterizedType)){
                break;
            }
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if (params == null || params.length < 2){
                break;
            }
            // TODO: 2016/11/11
        }
    }

}
