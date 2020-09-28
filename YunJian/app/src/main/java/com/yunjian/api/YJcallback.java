package com.yunjian.api;

/**
 * @author 吴立柳
 * @package com.yunjian.api
 * @date on 2020/9/26
 * @describe  回调接口
 */
public interface YJcallback {

    /**
     * 请求成功
     * @param res
     */
    void onSuccess(String res);

    /**
     * 请求失败
     * @param e
     */
    void onFailure(Exception e);
}
