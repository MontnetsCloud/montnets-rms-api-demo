package com.montnets.util;

import com.montnets.bean.request.send.*;
import com.montnets.bean.response.send.MultiDynamicSendResponse;
import com.montnets.bean.response.send.PreviewSendResponse;
import com.montnets.bean.response.send.SendResponse;
import com.montnets.bean.response.send.UniDynamicSendResponse;

/**
 * 富信模板请求  api
 *
 * @author montnets
 */
public class SendUtil {

    /**
     * 静态模板请求
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    public static SendResponse staticSend(String url, SendRequest request) {
        return post(url, request);
    }

    /**
     * 文本动参模板请求
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    public static SendResponse txtDynamicSend(String url, TxtDynamicSendRequest request) {
        return post(url, request);
    }

    /**
     * 图片动参模板请求
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    public static SendResponse picDynamicSend(String url, PicDynamicSendRequest request) {
        return post(url, request);
    }

    /**
     * 通用动参模板请求
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    public static UniDynamicSendResponse uniDynamicSend(String url, UniDynamicSendRequest request) {
        return post(url, request);
    }

    /**
     * 通用动参模板请求
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    public static MultiDynamicSendResponse multiDynamicSend(String url, MultiDynamicSendRequest request) {
        return post(url, request);
    }

    /**
     * 预览发送
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    public static PreviewSendResponse previewSend(String url, PreviewSendRequest request) {
        return post(url, request);
    }

    /**
     * post
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    private static PreviewSendResponse post(String url, PreviewSendRequest request) {
        // 获取旧密码
        String oldPwd = request.getPwd();
        // 填充请求对象
        RmsUtil.encryptPwd(request);
        // 设置 expire
        String expire = request.getExpire();
        if (null == expire) {
            request.setExpire("24");
        }
        // 设置 sign
        String sign = RmsUtil.encryptSign(request, oldPwd);
        request.setSign(sign);
        return HttpUtil.post(url, request, PreviewSendResponse.class);
    }


    /**
     * post
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    private static UniDynamicSendResponse post(String url, UniDynamicSendRequest request) {
        // 填充请求对象
        RmsUtil.encryptPwd(request);
        return HttpUtil.post(url, request, UniDynamicSendResponse.class);
    }

    /**
     * post
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    private static MultiDynamicSendResponse post(String url, MultiDynamicSendRequest request) {
        // 填充请求对象
        RmsUtil.encryptPwd(request);
        return HttpUtil.post(url, request, MultiDynamicSendResponse.class);
    }


    /**
     * post
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    private static SendResponse post(String url, SendRequest request) {
        // 填充请求对象
        RmsUtil.encryptPwd(request);
        return HttpUtil.post(url, request, SendResponse.class);
    }

}
