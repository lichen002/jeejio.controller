package com.imlp.devices;

import com.alibaba.fastjson.JSON;
import com.api.entity.devices.DevicesListOpen;
import com.api.service.devices.DevicesListService;

import java.io.IOException;

import static com.api.http.common.ApiPath.DEVICES_LIST;
import static com.api.http.common.HttpDelegate.postAndToken;

public class DevicesListServiceImpl implements DevicesListService {
    @Override
    public String devicesList(DevicesListOpen devicesListOpen) throws IOException {
        String request = JSON.toJSONString(devicesListOpen);
        return postAndToken(DEVICES_LIST,request);
    }
}
