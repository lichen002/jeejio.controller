package com.api.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.api.entity.apply.ApplyList;
import com.api.entity.apply.ApplyUnInstall;
import com.api.entity.devices.GetDevicesInstallApply;
import com.api.entity.login.LoginOpen;
import com.api.http.common.HttpDelegate;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static com.api.http.common.ApiPath.*;

@Slf4j
public class utils {

    /**
     *  获取登录的用户信息
     * @param userPhone
     * @param password
     * @return
     * @throws IOException
     */
    public static JSONObject getUserInfo(String userPhone,String password) throws IOException {
        LoginOpen loginOpen = new LoginOpen();
        loginOpen.setUserKey(userPhone);
        loginOpen.setUserPasswd(password);
        loginOpen.setPlatform("kf");
        loginOpen.setTool("1");
        String requestString = JSONObject.toJSONString(loginOpen);
        String loginResult = HttpDelegate.post(LOGIN_PATH, requestString);
        JSONObject response = JSON.parseObject(loginResult);
        log.info("response is {}",response);
        JSONObject resultValue =(JSONObject) response.get("resultValue");
        return resultValue;
    }


    public static JSONObject getApplyList(String machineCode,String machineTypeV,long userId,String userCode,String token,String sessionId) throws IOException {
        ApplyList applyList = new ApplyList();
        applyList.setMachineCode(machineCode);
        applyList.setMachineTypeV(machineTypeV);
        applyList.setPageNum(1);
        applyList.setPageSize(20);
        applyList.setUserId(userId);
        applyList.setUserCode(userCode);
        applyList.setToken(token);
        applyList.setSessionId(sessionId);
        String requestString = JSONObject.toJSONString(applyList);
        String appListResult = HttpDelegate.postAndToken(APPLY_LIST, requestString);
        JSONObject response = JSON.parseObject(appListResult);
        log.info("response is {}",response);
        return response;

    }

    /**
     * 清空设备上面已经安装的应用
     * @return
     */
    public static JSONObject clearDevicesInstallApply(ApplyUnInstall applyUnInstall) throws IOException {
        String request = JSON.toJSONString(applyUnInstall);
        String result = HttpDelegate.postAndToken(DEVICE_APPLY, request);
        JSONObject resultJsonObject = JSON.parseObject(result);
        return resultJsonObject;


    }

    /**
     * //获取设备上已经安装的应用
     * @param getDevicesInstallApply
     * @return
     * @throws IOException
     */
    public static JSONObject getDevicesInstllApply(GetDevicesInstallApply getDevicesInstallApply) throws IOException {

        String request = JSON.toJSONString(getDevicesInstallApply);
        String result = HttpDelegate.postAndToken(DEVICES_APPLY_INSTALL, request);
        JSONObject jsonObject = JSON.parseObject(result);
        return jsonObject;
    }


}
