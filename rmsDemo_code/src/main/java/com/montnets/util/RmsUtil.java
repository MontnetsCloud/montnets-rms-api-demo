package com.montnets.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSON;
import com.montnets.bean.request.BaseRequest;
import com.montnets.bean.request.send.PreviewSendRequest;
import com.montnets.bean.request.tpl.TplRequest;
import org.apache.commons.codec.binary.Base64;

import java.util.Date;

/**
 * 富信工具
 *
 * @author montnets
 */
public class RmsUtil {

    /**
     * 加密 request 对象, 设置用户, 密码, 时间戳
     *
     * @param request request 实体
     */
    public static void encryptPwd(BaseRequest request) {
        // 转化为大写, 以防大小写不一样
        request.setUserid(request.getUserid().toUpperCase());
        // 设置时间戳
        String timestamp = DateUtil.format(new Date(), "MMddHHmmss");
        request.setTimestamp(timestamp);
        // 对密码进行加密
        String encryptPwd = encryptPwd(request.getUserid(), request.getPwd(),
                request.getTimestamp());
        // 设置加密后的密码
        request.setPwd(encryptPwd);
    }

    /**
     * hexstrlowercase(md5(uppercase(userid) + 00000000 + 明文密码 + timestamp))
     * 密码加密
     *
     * @param userId    用户账号
     * @param oldPwd       用户原始密码
     * @param timestamp 时间戳
     * @return 加密后的密码
     */
    public static String encryptPwd(String userId, String oldPwd, String timestamp) {
        String passwordStr = userId.toUpperCase() + "00000000" + oldPwd + timestamp;
        return MD5.create().digestHex(passwordStr);
    }

    /**
     * hexstr_lowercase(md5(expire + name + title + uppercase(userid) + 明文密码 + timestamp + reslist))
     * 模板操作 sign 加密
     *
     * @param tplRequest 模板请求参数
     * @param oldPwd 旧密码
     * @return 执行结果
     */
    public static String encryptSign(TplRequest tplRequest, String oldPwd) {
        if (null == tplRequest) {
            return null;
        }
        String sign = tplRequest.getExpire() + tplRequest.getName() + tplRequest.getTitle()
                + tplRequest.getUserid().toUpperCase() + oldPwd + tplRequest.getTimestamp()
                + JSON.toJSONString(tplRequest.getReslist());
        // 对签名进行加密
        return MD5.create().digestHex(sign);
    }

    /**
     * hexstr_lowercase(md5(expire + title + uppercase(userid) + 明文密码 + timestamp + reslist + mobile))
     * 预览发送 sign 加密
     *
     * @param previewSendRequest 模板请求参数
     * @return 执行结果
     */
    public static String encryptSign(PreviewSendRequest previewSendRequest, String oldPwd) {
        if (null == previewSendRequest) {
            return null;
        }
        String sign = previewSendRequest.getExpire() + previewSendRequest.getTitle()
                + previewSendRequest.getUserid().toUpperCase() + oldPwd + previewSendRequest.getTimestamp()
                + JSON.toJSONString(previewSendRequest.getReslist()) + previewSendRequest.getMobile();
        // 对签名进行加密
        return MD5.create().digestHex(sign);
    }

    /**
     * 获取文件 base64, 建议使用 org.apache.commons.codec.binary.Base64
     *
     * @param path path
     * @return 执行结果
     */
    public static String getFileBase64(String path) {
        return Base64.encodeBase64String(FileUtil.readBytes(path));
    }

}
