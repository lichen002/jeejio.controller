package com.test.user;

import com.alibaba.fastjson.JSONObject;
import com.api.entity.user.JudgeUserExistOpen;
import com.api.entity.user.SetUserInfoOpen;
import com.api.utils.utils;
import com.imlp.user.info.UserInfoImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import static com.api.http.common.ApiPath.TEST_ACCOUNT;
import static com.api.http.common.ApiPath.TEST_PASSWORD;
import static java.lang.Thread.sleep;

@Slf4j
public class UserInfoTest {
    static String token;
    static String sessionId;
    static long userId;
    static String userCode;
    UserInfoImpl UserInfoImlp = new UserInfoImpl();

    @BeforeClass
    public static void setUp() throws IOException {
        JSONObject userInfo = utils.getUserInfo(TEST_ACCOUNT, TEST_PASSWORD);
        log.info("userInfo is {}",userInfo);
        userCode =(String) userInfo.get("userCode");
        userId =(Long) userInfo.get("id");
        token =(String) userInfo.get("token");
        sessionId =(String) userInfo.get("sessionId");
    }

    @Test
    //更改用户信息
    public void testSetUserInfo() throws IOException, InterruptedException {
        SetUserInfoOpen setUserInfoOpen = new SetUserInfoOpen();
        sleep(3000);
        setUserInfoOpen.setUserName("lciehn");
        setUserInfoOpen.setImgUrl("https://qauserimgs.jeejio.com/qa/202004031326/userinfo/2020-10-19/be710d73eb324d91928223e02a591310.jpg");
        setUserInfoOpen.setStatus(2);
        setUserInfoOpen.setUserBirth("2020-06-18");
        setUserInfoOpen.setUserId(userId);
        setUserInfoOpen.setSessionId(sessionId);
        setUserInfoOpen.setToken(token);
        String result = UserInfoImlp.setUserInfo(setUserInfoOpen);
        log.info("result is {}",result);

        JudgeUserExistOpen judgeUserExistOpen = new JudgeUserExistOpen();
        judgeUserExistOpen.setUserKey(TEST_ACCOUNT);
        judgeUserExistOpen.setStatus("2");
        String resultInfo = UserInfoImlp.judgeUserExist(judgeUserExistOpen);
        log.info("resultInfo is {}",resultInfo);



    }

}
