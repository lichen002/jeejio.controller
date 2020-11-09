package com.api.service.devices;

import com.api.entity.devices.DevicesListOpen;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface DevicesListService {
    public String devicesList(DevicesListOpen devicesListOpen) throws IOException;

}
