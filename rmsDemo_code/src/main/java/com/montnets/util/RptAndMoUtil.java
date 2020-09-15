package com.montnets.util;

import com.montnets.bean.request.BaseRequest;
import com.montnets.bean.request.mo.MoRequest;
import com.montnets.bean.request.rpt.RptRequest;
import com.montnets.bean.response.mo.MoResponse;
import com.montnets.bean.response.rpt.RptResponse;

/**
 * 状态报告和上行消息工具类
 *
 * @author montnets
 */
public class RptAndMoUtil {

    /**
     * 获取状态报告
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    public static RptResponse getRpt(String url, RptRequest request) {
        return post(url, request, RptResponse.class);
    }

    /**
     * 获取上行消息
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    public static MoResponse getMo(String url, MoRequest request) {
        return post(url, request, MoResponse.class);
    }


    /**
     * post
     *
     * @param url     请求地址
     * @param request 请求对象
     * @param clazz   响应类
     * @return 请求响应对象
     */
    private static <T> T post(String url, BaseRequest request, Class<T> clazz) {
        // 填充请求对象
        RmsUtil.encryptPwd(request);
        return HttpUtil.post(url, request, clazz);
    }
}
