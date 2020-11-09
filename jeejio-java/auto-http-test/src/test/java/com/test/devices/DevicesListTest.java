package com.test.devices;

import com.alibaba.fastjson.JSONObject;
import com.api.entity.devices.DevicesListOpen;
import com.api.utils.utils;
import com.imlp.devices.DevicesListServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

import static com.api.http.common.ApiPath.TEST_ACCOUNT;
import static com.api.http.common.ApiPath.TEST_PASSWORD;

@Slf4j
public class DevicesListTest {

         DevicesListServiceImpl devicesListService =   new DevicesListServiceImpl();


         @Test
    public void testDevicesList() throws IOException {
             DevicesListOpen devicesListOpen = new DevicesListOpen();
             JSONObject userInfo = utils.getUserInfo(TEST_ACCOUNT, TEST_PASSWORD);
             log.info("userInfo is {}",userInfo);
             String userCode =(String) userInfo.get("userCode");
             Long userId =(Long) userInfo.get("id");
             String token =(String) userInfo.get("token");
             String sessionId =(String) userInfo.get("sessionId");

             devicesListOpen.setUserCode(userCode);
             devicesListOpen.setUserId(userId);
             devicesListOpen.setToken(token);

             devicesListOpen.setSessionId(sessionId);
             String devicesListResult = devicesListService.devicesList(devicesListOpen);
             log.info("devicesListResult is {}",devicesListResult);



         }
}
