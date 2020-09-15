package com.montnets.util;

import com.montnets.bean.request.BaseRequest;
import com.montnets.bean.response.balance.BalanceResponse;

/**
 * 富信模板请求工具类
 *
 * @author montnets
 */
public class BalanceUtil {

    /**
     * 余额查询
     *
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    public static BalanceResponse balance(String url, BaseRequest request) {
        return post(url, request);
    }

    /**
     * post
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    private static BalanceResponse post(String url, BaseRequest request) {
        // 填充请求对象
        RmsUtil.encryptPwd(request);
        return HttpUtil.post(url, request, BalanceResponse.class);
    }

}
