package com.montnets;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.montnets.bean.Mo;
import com.montnets.bean.Rpt;
import com.montnets.bean.TplStatus;
import com.montnets.bean.request.callback.MoCallbackRequest;
import com.montnets.bean.request.callback.RptCallbackRequest;
import com.montnets.bean.request.callback.StatusCallbackRequest;
import com.montnets.bean.response.callback.CallbackResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 回调接口
 *
 * @author montnets
 */
@RestController
@SpringBootApplication
public class CallbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallbackApplication.class);
    }

    /**
     * 状态报告回调
     *
     * @param request 请求实体
     * @return 响应
     */
    @PostMapping("/rpt_callback")
    public CallbackResponse rptCallback(@RequestBody RptCallbackRequest request) {
        CallbackResponse response = new CallbackResponse();
        // 与请求的 seqid 一致
        response.setSeqId(request.getSeqid());
        // 固定填写
        response.setCmd("RPT_RESP");
        List<Rpt> rptList = request.getRpts();
        if (CollUtil.isEmpty(rptList)) {
            response.setResult(0);
            response.setDesc("rpts 为空");
            return response;
        }
        System.out.println(StrUtil.format("接收内容为: [{}], rpts 为: [{}]",
                JSON.toJSONString(request), JSON.toJSONString(rptList)));
        response.setResult(0);
        response.setDesc("接收成功");
        return response;
        // 建议生产环境中异步处理, 先回应, 再去做业务逻辑处理. 当前 demo 没有做异步处理(如: 状态报告匹配等)
    }

    /**
     * 上线消息回调
     *
     * @param request 请求实体
     * @return 响应
     */
    @PostMapping("/mo_callback")
    public CallbackResponse moCallback(@RequestBody MoCallbackRequest request) {
        CallbackResponse response = new CallbackResponse();
        // 与请求的 seqid 一致
        response.setSeqId(request.getSeqid());
        // 固定填写
        response.setCmd("MO_RESP");
        List<Mo> moList = request.getMos();
        if (CollUtil.isEmpty(moList)) {
            response.setResult(0);
            response.setDesc("mos 为空");
            return response;
        }
        System.out.println(StrUtil.format("接收内容为: [{}], mos 为: [{}]",
                JSON.toJSONString(request), JSON.toJSONString(moList)));
        response.setResult(0);
        response.setDesc("接收成功");
        return response;
        // 建议生产环境中异步处理, 先回应, 再去做业务逻辑处理. 当前 demo 没有做异步处理(如: 上行信息入库等)
    }

    /**
     * 模板状态回调
     *
     * @param request 请求实体
     * @return 响应
     */
    @PostMapping("/tplStatus_callback")
    public CallbackResponse tplStatusCallback(@RequestBody StatusCallbackRequest request) {
        CallbackResponse response = new CallbackResponse();
        // 与请求的 seqid 一致
        response.setSeqId(request.getSeqid());
        // 固定填写
        response.setCmd("VFYSTS_RESP");
        List<TplStatus> tplstList = request.getTplsts();
        if (CollUtil.isEmpty(tplstList)) {
            response.setResult(0);
            response.setDesc("tplsts 为空");
            return response;
        }
        System.out.println(StrUtil.format("接收内容为: [{}], tplsts 为: [{}]",
                JSON.toJSONString(request), JSON.toJSONString(tplstList)));
        response.setResult(0);
        response.setDesc("接收成功");
        return response;
        // 建议生产环境中异步处理, 先回应, 再去做业务逻辑处理. 当前 demo 没有做异步处理(如: 模板状态更新等)
    }

}
