package com.bootjdbc.demo.util;/**
 * @Auther: hyy
 * @Date:2021/7/14 - 07 - 14 7:59
 * @Description:com.aoyang.health.util
 * @Version: 1.0
 */

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 *@author
 *@date2021/7/14 7:59
 *
 *
 */
public class HeSuanSoapUtil {


    private static Logger LOGGER = Logger.getLogger(HeSuanSoapUtil.class);


    /**
     *请求获取患者信息
     */
    public String getHeSuan(String cardType,String cardNo){
        String soqpMethod="RequestSubmit";
        String inputCode="300";// 300 通过卡号及患者No获取患者基本信息
        String inputString="<Request><cardType>"+cardType+"</cardType><cardNo>"+cardNo+"</cardNo></Request>";
        Map<String,Object> param=new HashMap<>();
        param.put("soap_method",soqpMethod);
        param.put("InputCode",inputCode);
        param.put("InputString",inputString);
        String url="http://172.23.112.48:57772/csp/healthshare/ayyy/AYYY.Queue.BS.QueueService.cls";
        String result= HttpUtil.post(url,param);
        LOGGER.info("请求获取患者信息===>"+result);
        return result;
    }
    /**
     *请求获取患者就诊信息
     */
    public String getMedicalRecords(String PatientNo,String WaiteDays){
        String soqpMethod="RequestSubmit";
        String inputCode="301";//301 报道机向东华HIS系统获取就诊记录
        String inputString= "<Request><PatientNo>"+PatientNo+"</PatientNo><WaiteDays>"+WaiteDays+"</WaiteDays><MachineNo>BDJ001</MachineNo></Request>";
        Map<String,Object> param=new HashMap<>();
        param.put("soap_method",soqpMethod);
        param.put("InputCode",inputCode);
        param.put("InputString",inputString);
        String url="http://172.23.112.48:57772/csp/healthshare/ayyy/AYYY.Queue.BS.QueueService.cls";
        String result= HttpUtil.post(url,param);
        LOGGER.info("请求取患者就诊信息===>"+result);
        return result;
    }

    /**
     *请求获取患者报道信息
     */
    public String getBaoRecords(String AdmRowId){
        String soqpMethod="RequestSubmit";
        String inputCode="302";//302 报道机向东华HIS系统推送报道确认接口
        String inputString= "<Request><AdmRowId>"+AdmRowId+"</AdmRowId><MachineNo>BDJ001</MachineNo></Request>";
        Map<String,Object> param=new HashMap<>();
        param.put("soap_method",soqpMethod);
        param.put("InputCode",inputCode);
        param.put("InputString",inputString);
        String url="http://172.23.112.48:57772/csp/healthshare/ayyy/AYYY.Queue.BS.QueueService.cls";
        String result= HttpUtil.post(url,param);
        LOGGER.info("请求患者报道信息===>"+result);
        return result;
    }




    /**
     * 解析xml
     */
    public String JieXiXml(String strXml){
        JsonXmlUtils jsonXmlUtils=new JsonXmlUtils();
        JSONObject a= jsonXmlUtils.xml2Json(strXml);

        JSONObject body=(JSONObject)a.get("Body");

        JSONObject RequestSubmitResponse=(JSONObject) body.get("RequestSubmitResponse") ;

        String RequestSubmitResult= RequestSubmitResponse.getString("RequestSubmitResult");
        LOGGER.info("RequestSubmitResult内容====>"+RequestSubmitResult);
//        JSONObject RequestSubmitResults= jsonXmlUtils.xml2Json(RequestSubmitResult);
//        System.out.println(RequestSubmitResults);
        return  RequestSubmitResult;

    }

}
