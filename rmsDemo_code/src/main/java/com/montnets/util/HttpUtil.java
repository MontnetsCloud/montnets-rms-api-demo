package com.montnets.util;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.montnets.bean.request.BaseRequest;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;


/**
 * Http 发送工具类
 *
 * @author montnets
 */
public class HttpUtil {

    /**
     * Post 请求
     *
     * @param request 请求对象
     * @param url 请求地址
     * @return 请求网关返回的值
     */
    public static<T> T post(String url, BaseRequest request, Class<T> clazz) {
        url = "http://" + url;
        OutputStreamWriter out = null;
        InputStream in = null;
        ByteArrayOutputStream bs = null;
        BufferedWriter bw = null;
        try {
            // 参数
            String params = JSON.toJSONString(request);
            System.out.println(StrUtil.format("请求地址: {}, 请求参数: {}", url, params));
            URLConnection urlConnection = new URL(url).openConnection();
            HttpURLConnection httpUrlConnection = (HttpURLConnection) urlConnection;
            // 设置超时时间
            httpUrlConnection.setConnectTimeout(5 * 1000);
            // 设置是否向 httpUrlConnection 输出，post 请求，参数要放在 http 正文内，因此需要设为 true,
            // 默认情况下是 false;
            httpUrlConnection.setDoOutput(true);
            // 设置是否从 httpUrlConnection 读入，默认情况下是 true;
            httpUrlConnection.setDoInput(true);
            // 忽略缓存
            httpUrlConnection.setUseCaches(false);
            // 设定请求的方法为 "POST"，默认是 GET
            httpUrlConnection.setRequestMethod("POST");
            // 设置编码语言
            httpUrlConnection.setRequestProperty("Accept-Charset", "UTF-8");
            httpUrlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpUrlConnection.setRequestProperty("accept", "application/json");
            httpUrlConnection.setRequestProperty("Charset", "UTF-8");
            httpUrlConnection.setRequestProperty("Connection", "Keep-Alive");
            out = new OutputStreamWriter(httpUrlConnection.getOutputStream(), StandardCharsets.UTF_8);
            bw = new BufferedWriter(out);
            bw.write(params);
            bw.flush();
            bw.close();
            // 获得响应状态
            int responseCode = httpUrlConnection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode) {
                bs = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                in = httpUrlConnection.getInputStream();
                while ((len = in.read(buffer)) != -1) {
                    bs.write(buffer, 0, len);
                    bs.flush();
                }
                String result = bs.toString("UTF-8");
                return JSON.parseObject(result, clazz);
            }
            httpUrlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IoUtil.close(in);
            IoUtil.close(out);
            IoUtil.close(bs);
            IoUtil.close(bw);
        }
        return null;
    }

}
