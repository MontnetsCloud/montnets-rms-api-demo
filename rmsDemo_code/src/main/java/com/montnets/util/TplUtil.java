package com.montnets.util;

import cn.hutool.core.util.StrUtil;
import com.montnets.bean.request.tpl.*;
import com.montnets.bean.response.tpl.StatusResponse;
import com.montnets.bean.response.tpl.TemplateResponse;
import com.montnets.bean.response.tpl.TplManagerResponse;

/**
 * 富信模板请求工具类
 *
 * @author montnets
 */
public class TplUtil {

    /**
     * 模板上传
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    public static TemplateResponse tplUpload(String url, UploadRequest request) {
        return post(url, request);
    }

    /**
     * 模板修改
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    public static TemplateResponse tplModify(String url, ModifyRequest request) {
        return post(url, request);
    }

    /**
     * 模板状态查询
     *
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    public static StatusResponse tplStatusQuery(String url, StatusRequest request) {
        return post(url, request);
    }

    /**
     * 模板管理查询
     *
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    public static TplManagerResponse tplManager(String url, TplManagerRequest request) {
        return post(url, request);
    }


    /**
     * post
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    private static TplManagerResponse post(String url, TplManagerRequest request) {
        // 填充请求对象
        RmsUtil.encryptPwd(request);
        return HttpUtil.post(url, request, TplManagerResponse.class);
    }

    /**
     * post
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    private static StatusResponse post(String url, StatusRequest request) {
        // 填充请求对象
        RmsUtil.encryptPwd(request);
        return HttpUtil.post(url, request, StatusResponse.class);
    }


    /**
     * post
     *
     * @param url     请求地址
     * @param request 请求对象
     * @return 请求响应对象
     */
    private static TemplateResponse post(String url, TplRequest request) {
        String oldPwd = request.getPwd();
        // 填充请求对象
        RmsUtil.encryptPwd(request);
        // 设置 expire
        if (null == request.getExpire()) {
            request.setExpire("24");
        }
        // 设置 sign
        String sign = RmsUtil.encryptSign(request, oldPwd);
        request.setSign(sign);
        return HttpUtil.post(url, request, TemplateResponse.class);
    }

}
