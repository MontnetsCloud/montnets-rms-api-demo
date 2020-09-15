package com.montnets;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.montnets.bean.DynamicResource;
import com.montnets.bean.RmsResource;
import com.montnets.bean.request.BaseRequest;
import com.montnets.bean.request.mo.MoRequest;
import com.montnets.bean.request.rpt.RptRequest;
import com.montnets.bean.request.send.*;
import com.montnets.bean.request.tpl.ModifyRequest;
import com.montnets.bean.request.tpl.StatusRequest;
import com.montnets.bean.request.tpl.TplManagerRequest;
import com.montnets.bean.request.tpl.UploadRequest;
import com.montnets.bean.response.balance.BalanceResponse;
import com.montnets.bean.response.mo.MoResponse;
import com.montnets.bean.response.rpt.RptResponse;
import com.montnets.bean.response.send.MultiDynamicSendResponse;
import com.montnets.bean.response.send.PreviewSendResponse;
import com.montnets.bean.response.send.SendResponse;
import com.montnets.bean.response.send.UniDynamicSendResponse;
import com.montnets.bean.response.tpl.StatusResponse;
import com.montnets.bean.response.tpl.TemplateResponse;
import com.montnets.bean.response.tpl.TplManagerResponse;
import com.montnets.util.*;

import java.util.*;

/**
 * 富信 API demo
 *
 * @author  montnets
 */
public class Main {

    /**
     * 通用地址
     */
    private static final String UNI_URL = "192.169.6.248:9092";

    /**
     * 模板相关地址
     */
    private static final String TPL_URL = "192.169.6.248:5426";

    /**
     * 用户名
     */
    private static final String USER_ID = "HJL001";

    /**
     * 密码
     */
    private static final String PWD = "123456";

    /**
     * 时间常量, 5 分钟
     */
    private static final long FIVE_MINUTE = 5 * 1000 * 60L;

    /**
     * 请单个调试每一个方法
     * 1. 生产中的状态报告, 上行消息, 模板状态获取都应该使用线程池持续获取.
     * 2. 生产中的发送建议使用多线程进行发送, 同时搭配 Http 连接池
     * @param args /
     */
    public static void main(String[] args) {
        // 1. 模板上传
        tplUpload();
        // 2. 模板修改
        tplModify();
        // 3. 模板管理
        tplManager();
        // 4. 模板状态查询
        tplStatusQuery();
        // 5. 静态模板发送
        staticTplSend();
        // 6. 文本动参模板发送
        txtDynamicSend();
        // 7. 图片动参模板发送
        picDynamicSend();
        // 8. 通用动参模板发送
        uniDynamicSend();
        // 9. 个性化动参模板发送
        multiDynamicSend();
        // 10. 预览发送
        previewSend();
        // 11. 获取状态报告
        getRpt();
        // 12. 获取上行消息
        getMo();
        // 13. 查询余额
        balance();
    }

    /**
     * 初始化请求对象, 设置用户名和密码
     */
    private static void initRequest(BaseRequest request) {
        // 设置用户名
        request.setUserid(USER_ID);
        // 设置密码
        request.setPwd(PWD);
    }

    /**
     * 静态模板发送
     */
    public static void staticTplSend() {
        System.out.println("----------------------------- 静态模板发送 -----------------------------------");
        String url = UNI_URL + "/rms/v3/std/msg/stc_tpl_send";
        // 创建发送对象
        SendRequest request = new SendRequest();
        // 初始化请求对象
        initRequest(request);
        // 设置模板 ID
        request.setTplid("817858497");
        // 设置手机号码
        request.setMobile("15625255793");
        // 设置扩展号
        request.setExno("006");
        // 用户自定义流水编号
        request.setCustid("56asdd-47503-abce");
        // 自定义扩展数据
        request.setExdata("exdata");
        // 业务类型
        request.setSvrtype("test");
        // 补发短信内容
        request.setSuppmsg("补发短信内容");
        SendResponse sendResponse = SendUtil.staticSend(url, request);
        System.out.println(StrUtil.format("响应内容: {}", JSON.toJSON(sendResponse)));
    }

    /**
     * 文本动态参数模板发送
     */
    public static void txtDynamicSend() {
        System.out.println("----------------------------- 文本动参模板发送 -----------------------------------");
        String url = UNI_URL + "/rms/v3/std/msg/dynatxt_tpl_send";
        // 创建发送对象
        TxtDynamicSendRequest request = new TxtDynamicSendRequest();
        // 初始化请求对象
        initRequest(request);
        // 设置模板 ID
        request.setTplid("817858472");
        // 设置手机号码
        request.setMobile("15625255791,15625255790");
        // 设置内容, 必须是 JSON 字符串, 参数个数与模板参数个数保持一致
        Map<String, String> paramMap = new LinkedHashMap<>();
        paramMap.put("p1", "参数1");
        paramMap.put("p2", "参数2");
        paramMap.put("p3", "参数3");
        request.setContent(JSON.toJSONString(paramMap));
        // 设置扩展号
        request.setExno("006");
        // 用户自定义流水编号
        request.setCustid("56asdd-47503-abce");
        // 自定义扩展数据
        request.setExdata("exdata");
        // 业务类型
        request.setSvrtype("test");
        // 补发短信内容
        request.setSuppmsg("补发短信内容");
        SendResponse sendResponse = SendUtil.txtDynamicSend(url, request);
        System.out.println(StrUtil.format("响应内容: {}", JSON.toJSON(sendResponse)));
    }

    /**
     * 图文动态参数模块发送
     */
    public static void picDynamicSend() {
        System.out.println("----------------------------- 图片动参模板发送 -----------------------------------");
        String url = UNI_URL + "/rms/v3/std/msg/dynapic_tpl_send";
        // 创建发送对象
        PicDynamicSendRequest request = new PicDynamicSendRequest();
        // 初始化请求对象
        initRequest(request);
        // 设置模板 ID
        request.setTplid("817858517");
        // 富信有效期
        request.setExpire("24");
        // 设置手机号码
        request.setMobile("15625255791,15625255790");
        // 这里的 content 必须是 JSON 字符串而不是对象,
        // 所以这里我用了 JSON.toJSONString 去转化
        request.setContent(getContent());
        // 设置扩展号
        request.setExno("006");
        // 用户自定义流水编号
        request.setCustid("56asdd-47503-abce");
        // 自定义扩展数据
        request.setExdata("exdata");
        // 业务类型
        request.setSvrtype("test");
        // 补发短信内容
        request.setSuppmsg("补发短信内容");
        SendResponse sendResponse = SendUtil.picDynamicSend(url, request);
        System.out.println(StrUtil.format("响应内容: {}", JSON.toJSON(sendResponse)));
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * 获取 content JSON 字符串
     */
    private static String getContent() {
        // 设置内容
        Map<String, DynamicResource> content = new LinkedHashMap<>();
        // 内容 1
        DynamicResource resource = new DynamicResource();
        resource.setType("txt");
        resource.setSource("txt");
        resource.setContent("123");
        content.put("p1", resource);
        // 内容 2
        DynamicResource resource2 = new DynamicResource();
        resource2.setType("jpg");
        resource2.setSource("url");
        resource2.setContent("https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg");
        content.put("p2", resource2);
        return JSON.toJSONString(content);
    }

    /**
     * 通用动参模板发送
     */
    public static void uniDynamicSend() {
        System.out.println("----------------------------- 通用动参模板发送 -----------------------------------");
        String url = UNI_URL + "/rms/v3/std/msg/uni_tpl_send";
        // 创建发送对象
        UniDynamicSendRequest request = new UniDynamicSendRequest();
        // 设置模板 ID
        request.setTplid("817858517");
        // 初始化请求对象
        initRequest(request);
        // 设置手机号码
        request.setMobile("15625255791,15625255790");
        // 富信有效期
        request.setExpire("24");
        // 设置内容
        // 这里的 content 必须是 JSON 字符串而不是对象, 所以这里我用了 JSON.toJSONString 去转化
        request.setContent(getContent());
        // 设置扩展号
        request.setExno("006");
        // 用户自定义流水编号
        request.setCustid("56asdd-47503-abce");
        // 自定义扩展数据
        request.setExdata("exdata");
        // 业务类型
        request.setSvrtype("test");
        // 补发短信内容
        request.setSuppmsg("补发短信内容");
        UniDynamicSendResponse sendResponse = SendUtil.uniDynamicSend(url, request);
        System.out.println(StrUtil.format("响应内容: {}", JSON.toJSON(sendResponse)));
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     *
     */
    private static void multiDynamicSend() {
        System.out.println("----------------------------- 个性化动参模板发送 -----------------------------------");
        String url = UNI_URL + "/rms/v3/std/msg/multi_tpl_send";
        // 创建发送对象
        MultiDynamicSendRequest request = new MultiDynamicSendRequest();
        // 设置模板 ID
        request.setTplid("817859929");
        // 初始化请求对象
        initRequest(request);
        // 富信有效期
        request.setExpire("24");
        // 设置内容
        // 这里的 content 必须是 JSON 字符串而不是对象, 所以这里我用了 JSON.toJSONString 去转化
        request.setMultimt(getMultiMt());
        // 设置扩展号
        request.setExno("006");
        // 用户自定义流水编号
        request.setCustid("56asdd-47503-abce");
        // 自定义扩展数据
        request.setExdata("exdata");
        // 业务类型
        request.setSvrtype("test");
        // 补发短信内容
        request.setSuppmsg("补发短信内容");
        MultiDynamicSendResponse sendResponse = SendUtil.multiDynamicSend(url, request);
        System.out.println(StrUtil.format("响应内容: {}", JSON.toJSON(sendResponse)));
        System.out.println("-----------------------------------------------------------------------------");
    }

    private static List<Map<String, Object>> getMultiMt() {
        List<Map<String, Object>> multiMt = new LinkedList<>();
        // 最大支持 5000 个手机号
        for (int i = 0; i < 10; i++) {
            Map<String, Object> res = new HashMap<>();
            res.put("mobile", String.valueOf(15625255800L + i));
            // 内容 1
            DynamicResource resource = new DynamicResource();
            resource.setType("txt");
            resource.setSource("txt");
            resource.setContent(StrUtil.format("第{}个手机号个性化文本内容", i));
            res.put("p1", resource);
            // 内容 2, 图片内容
            DynamicResource resource2 = new DynamicResource();
            resource2.setType("jpg");
            resource2.setSource("url");
            resource2.setContent("https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg");
            res.put("p2", resource2);
            multiMt.add(res);
        }
        return multiMt;
    }

    /**
     * 预览发送
     */
    public static void previewSend() {
        System.out.println("----------------------------- 预览发送 -----------------------------------");
        String url = UNI_URL + "/rms/v3/std/msg/rms_send";
        // 创建发送对象
        PreviewSendRequest request = new PreviewSendRequest();
        // 初始化请求对象
        initRequest(request);
        // 设置富信主题
        request.setTitle("富信主题");
        // 设置手机号码
        request.setMobile("13538277877,13538234544");
        // 获取资源
        List<RmsResource> resList = new ArrayList<>();
        // 第一帧资源
        RmsResource res1 = new RmsResource();
        res1.setIndex("1-1");
        res1.setType("txt");
        res1.setName("txt_test");
        res1.setSource("txt");
        // 第一个文本帧必须带签名
        res1.setContent("【三部1】测试11");
        resList.add(res1);
        // 第二帧资源
        RmsResource res2 = new RmsResource();
        res2.setIndex("2-1");
        res2.setType("txt");
        res2.setName("txt_test");
        res2.setSource("txt");
        res2.setContent("文本测试哈哈哈");
        resList.add(res2);
        //第三帧资源
        RmsResource res3 = new RmsResource();
        res3.setIndex("3-1");
        res3.setType("jpg");
        res3.setName("a.jpg");
        res3.setSource("url");
        res3.setContent("http://192.169.1.216:8888/fuxin/15.jpg");
        resList.add(res3);
        RmsResource res4 = new RmsResource();
        res4.setIndex("4-1");
        res4.setType("jpg");
        res4.setName("03.jpg");
        res4.setSource("file");
        res4.setContent(RmsUtil.getFileBase64("source/03.jpg"));
        resList.add(res4);
        request.setReslist(resList);
        // 设置扩展号
        request.setExno("006");
        // 用户自定义流水编号
        request.setCustid("56asdd-47503-abce");
        // 自定义扩展数据
        request.setExdata("exdata");
        // 业务类型
        request.setSvrtype("test");
        // 富信类型
        request.setRmstype("1");
        // 补发短信内容
        request.setSuppmsg("补发短信内容");
        PreviewSendResponse sendResponse = SendUtil.previewSend(url, request);
        System.out.println(StrUtil.format("响应内容: {}", JSON.toJSON(sendResponse)));
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * 模板上传
     */
    public static void tplUpload() {
        System.out.println("----------------------------- 模板上传 -----------------------------------");
        String url = TPL_URL + "/rms/v3/std/tpl/tpl_upload";
        UploadRequest request = new UploadRequest();
        // 初始化请求对象
        initRequest(request);
        // 设置模板有效期
        request.setExpire("60");
        // 模板名称
        request.setName("风景模板");
        // 富信主题
        request.setTitle("旅游通知");
        // 设置富信资源列表
        List<RmsResource> resList = getResource();
        // 富信资源列表
        request.setReslist(resList);
        // 用户自定义流水编号
        request.setCustid("70e55826e6e-23456789");
        // 模板备注
        request.setRemarks("模板备注");
        // 模板审批结果提醒对象, 多个用逗号隔开, 最多支持 5 个
        request.setReminders("15625255791,15625255781");
        TemplateResponse templateResponse = TplUtil.tplUpload(url, request);
        System.out.println(StrUtil.format("响应内容: {}", JSON.toJSON(templateResponse)));
        // 这个模板 ID 要保存起来， 发送, 修改查询使用
        System.out.println(StrUtil.format("重要事情说三遍, 这个模板 ID 要保存起来， " +
                "发送, 修改查询使用, tplid: [{}]", templateResponse.getTplid()));
        System.out.println(StrUtil.format("重要事情说三遍, 这个模板 ID 要保存起来， " +
                "发送, 修改查询使用, tplid: [{}]", templateResponse.getTplid()));
        System.out.println(StrUtil.format("重要事情说三遍, 这个模板 ID 要保存起来， " +
                "发送, 修改查询使用, tplid: [{}]", templateResponse.getTplid()));
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * 模板修改, 审核中和审核通过的模板不能修改
     */
    public static void tplModify() {
        System.out.println("----------------------------- 模板修改 -----------------------------------");
        String url = TPL_URL + "/rms/v3/std/tpl/tpl_modify";
        ModifyRequest request = new ModifyRequest();
        // 初始化请求对象
        initRequest(request);
        // 待修改模板 id
        request.setTplid("817858521");
        // 设置模板有效期
        request.setExpire("60");
        // 模板名称
        request.setName("风景模板(修改)");
        // 富信主题
        request.setTitle("海南旅游通知(修改)");
        // 处理富信资源
        List<RmsResource> resList = getResource();
        // 富信资源列表
        request.setReslist(resList);
        // 用户自定义流水编号
        request.setCustid("70e55826e6e-23456789-edit");
        // 模板备注
        request.setRemarks("模板备注");
        // 模板审批结果提醒对象, 多个用逗号隔开, 最多支持 5 个
        request.setReminders("15625255791,15625255781");
        TemplateResponse templateResponse = TplUtil.tplModify(url, request);
        System.out.println(StrUtil.format("响应内容: {}", JSON.toJSON(templateResponse)));
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * 模板状态查询, 当前 demo 持续作为演示只运行 5 分钟, 生产建议对审核中的模板持续查询
     * 直到获取到最终的审核状态为止， 最终审核状态包括审核通过和审核不通过
     */
    public static void tplStatusQuery() {
        String url = TPL_URL + "/rms/v3/std/tpl/tplsts_query";
        StatusRequest request = new StatusRequest();
        // 设置模板 id
        request.setTplid("817859922,817859921");
        // 创建线程, 模板状态查询, 当前 demo 持续作为演示只运行 5 分钟, 生产建议对审核中的模板持续查询
        // 直到获取到最终的审核状态为止， 最终审核状态包括审核通过和审核不通过
        ThreadUtil.execAsync(() -> {
            long time = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time) <= FIVE_MINUTE) {
                System.out.println("----------------------------- 模板状态查询 -----------------------------------");
                // 初始化请求对象
                initRequest(request);
                StatusResponse statusResponse = TplUtil.tplStatusQuery(url, request);
                System.out.println(StrUtil.format("响应内容: {}", JSON.toJSON(statusResponse)));
                // 休眠 2 秒
                ThreadUtil.sleep(2000L);
                System.out.println("-----------------------------------------------------------------------------");
            }
        });
    }

    /**
     * 获取状态报告, 当前 demo 持续作为演示只运行 5 分钟, 生产建议持续运行(while(flag) 或 while(true))
     */
    public static void getRpt() {
        String url = UNI_URL + "/rms/v3/std/msg/get_rpt";
        RptRequest request = new RptRequest();
        // 最大 500
        request.setRetsize(500);
        // 创建线程, 当前 demo 持续作为演示只运行 5 分钟, 生产建议持续运行(while(flag) 或 while(true))
        ThreadUtil.execAsync(() -> {
            long time = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time) <= FIVE_MINUTE) {
                System.out.println("----------------------------- 获取状态报告 -----------------------------------");
                // 初始化请求对象
                initRequest(request);
                RptResponse rptResponse = RptAndMoUtil.getRpt(url, request);
                if (CollUtil.isNotEmpty(rptResponse.getRpts())) {
                    System.out.println(StrUtil.format("响应内容: {}", JSON.toJSON(rptResponse)));
                } else {
                    // 如果返回值为空, 则休眠 2 秒
                    ThreadUtil.sleep(2000L);
                }
                System.out.println("-----------------------------------------------------------------------------");
            }
        });
    }

    /**
     * 获取上行消息, 当前 demo 持续作为演示只运行 5 分钟, 生产建议持续运行(while(flag) 或 while(true))
     */
    public static void getMo() {
        String url = UNI_URL + "/rms/v3/std/msg/get_mo";
        MoRequest request = new MoRequest();
        // 最大 200
        request.setRetsize(200);
        // 创建线程, 获取上行消息, 当前 demo 持续作为演示只运行 5 分钟, 生产建议持续运行(while(flag) 或 while(true))
        ThreadUtil.execAsync(() -> {
            long time = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time) <= FIVE_MINUTE) {
                System.out.println("----------------------------- 获取上行消息 -----------------------------------");
                // 初始化请求对象
                initRequest(request);
                MoResponse moResponse = RptAndMoUtil.getMo(url, request);
                if (CollUtil.isNotEmpty(moResponse.getMos())) {
                    System.out.println(StrUtil.format("响应内容: {}", JSON.toJSON(moResponse)));
                } else {
                    // 如果获取不到数据, 则休眠 2 s
                    ThreadUtil.sleep(2000L);
                }
                System.out.println("-----------------------------------------------------------------------------");
            }
        });
    }

    /**
     * 模板管理
     */
    public static void tplManager() {
        System.out.println("----------------------------- 模板管理 -----------------------------------");
        String url = TPL_URL + "/rms/v3/std/tpl/tpl_mgr";
        TplManagerRequest request = new TplManagerRequest();
        // 初始化请求对象
        initRequest(request);
        // 模板 id
        request.setTplid("817858472");
        // 操作类型
        request.setOptype("1");
        TplManagerResponse managerResponse = TplUtil.tplManager(url, request);
        System.out.println(StrUtil.format("响应内容: {}", JSON.toJSON(managerResponse)));
        System.out.println("-----------------------------------------------------------------------------");
    }


    /**
     * 查询余额
     */
    public static void balance() {
        System.out.println("----------------------------- 查询余额 -----------------------------------");
        String url = UNI_URL + "/rms/v3/std/balance_query";
        BaseRequest request = new BaseRequest();
        // 初始化请求对象
        initRequest(request);
        BalanceResponse balanceResponse = BalanceUtil.balance(url, request);
        System.out.println(StrUtil.format("响应内容: {}", JSON.toJSON(balanceResponse)));
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * 获取富信资源
     */
    private static List<RmsResource> getResource() {
        List<RmsResource> resList = new ArrayList<>();
        // 第一帧资源 txt
        RmsResource res1 = new RmsResource();
        res1.setIndex("2-1");
        res1.setType("jpg");
        res1.setName("02.jpg");
        res1.setSource("file");
        res1.setContent(RmsUtil.getFileBase64("source/02.jpg"));
        resList.add(res1);
        // 第二帧资源
        RmsResource res2 = new RmsResource();
        res2.setIndex("1-1");
        res2.setType("txt");
        res2.setName("文本.txt");
        res2.setSource("txt");
        res2.setContent("尊敬的#p_1#你好, 你#p_2#月的账单如下:");
        resList.add(res2);
        //第三帧资源
        RmsResource res3 = new RmsResource();
        res3.setIndex("3-1");
        res3.setType("mp3");
        res3.setName("04.mp3");
        res3.setSource("file");
        res3.setContent(RmsUtil.getFileBase64("source/04.mp3"));
        resList.add(res3);
        //第四帧资源
        RmsResource res4 = new RmsResource();
        res4.setIndex("4-1");
        res4.setType("mp4");
        res4.setName("05.mp4");
        res4.setSource("file");
        res4.setContent(RmsUtil.getFileBase64("source/05.mp4"));
        resList.add(res4);
        //第五帧资源
        RmsResource res5 = new RmsResource();
        res5.setIndex("5-1");
        res5.setType("png");
        res5.setName("06.png");
        res5.setSource("url");
        res5.setContent("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
        resList.add(res5);
        return resList;
    }
}
