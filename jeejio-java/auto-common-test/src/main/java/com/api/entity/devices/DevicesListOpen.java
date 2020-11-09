package com.api.entity.devices;

import lombok.Data;

@Data
public class DevicesListOpen {
    private Long userId;
    private String userCode;
    private String token;
    private String sessionId;
}
