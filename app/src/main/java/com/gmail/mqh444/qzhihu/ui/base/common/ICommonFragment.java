package com.gmail.mqh444.qzhihu.ui.base.common;

/**
 * ICommonFragment
 * Created by Louis on 2016/11/10.
 */

public interface ICommonFragment {

    String EXTRA_REQ = "extra_req";

    String EXTRA_RESP = "extra_resp";

    /**
     * 当父activity点击触发onPressBack()对象，调用此方法，返回true则不调用父中的back
     *
     * @return
     */
    boolean onActivityPressBack();

    /**
     * 当父activity点击触发onSupportNavigateUp()时候，调用此方法，返回true则调用父中的back
     *
     * @return
     */
    boolean onActivitySupportNavigateUp();
}
