package com.api.http.common;

public interface ApiPath {
   String DVICES_HOST = "https://machine.qajeejio.com/";
   String APPLY_HOST = "https://appmarket.qajeejio.com/";
   String USER_HOST = "https://jeejiouser.qajeejio.com/";
   String TEST_ACCOUNT = "15701188230";
   String TEST_PASSWORD = "1111qqqq";
   String IMAGE_SUPER_CODE = "6666";
   String PHONE_SUPER_CODE = "888888";
   String TEST_EMAIL_ACCOUNT = "18201422725@163.com";
   String TEST_EMAIL_ACCOUNT2 = "844981671@qq.com";
   String TEST_MACHINE_CODE = "0127180000180000001d";


   //识别字符
   Integer TEST_PASS_SUCCESS = 1;
   Integer TEST_PASS_CODE = 200;
   Integer TEST_ERROR_SUCCESS = 0;
   Integer APPLY_SOURCE = 1;
   Integer APPLY_THEMEID = 0;
   Integer APPLY_EVENTTYPE = 5;//
   Integer APPLY_EVENTTYPE_INSTALL = 1;//安装应用
   Integer APPLY_EVENTTYPE_UNINSTALL = 2;//卸载应用
   Integer APPLY_EVENTTYPE_OPEN = 4; //启动应用
   Integer APPLY_EVENTTYPE_CLOSE = 5; //关闭应用

   //贝多盒设备接口地址
   String DEVICES_PATH = "device/machine/v2/";
   String DEVICES_LIST = DVICES_HOST+DEVICES_PATH+"getMachineManageList";

   //获取设备上面已经安装的应用
   String DEVICES_APPLY = "device/app/v2/";
   String DEVICES_APPLY_INSTALL =DVICES_HOST+DEVICES_APPLY+"listMachineAppInfo";




   //贝多盒应用接口地址
   String APPLY_PATH ="appMarket/soft/";
   String DEVICE_APPLY_PATH = "device/machine/";
   String APPLY_OPEN = APPLY_HOST+APPLY_PATH+"invokingMachineByDm";
   String APPLY_LIST = APPLY_HOST+APPLY_PATH+"listNewAppsByDm";
   String APPLY_INSTALL =APPLY_HOST+APPLY_PATH+ "invokingMachineByDm";
   String DEVICE_APPLY =DVICES_HOST+DEVICE_APPLY_PATH+ "invokingMachine";
   String DEVICES_UNINSTALL_APPLY = "";


   //贝多盒用户信息接口
   String USER_PATH = "user/person/";
   String SET_USER_INFO =USER_HOST+USER_PATH+ "changeUserInfoControl";
   String GET_USER_INFO = USER_HOST+"user/users/judgeIsUserExist";

   /*
   接口地址
    */
   String SERVICE_DEVICES = "http://10.10.11.98";
   String LOGIN_OUT_SERVICE_PATH = "http://10.10.11.61:8501/user/sso/logoutUser";
   String UNBIND_DEVICES_RESTORE_NETWORK = SERVICE_DEVICES+"/machine/machine/unbindMachine";
   String GET_DEVICES_LIST = SERVICE_DEVICES+"/machine/machine/getMachineManageList";
   String RESET_PASSWORD = SERVICE_DEVICES+"/user/users/setOrChangePassword";
   String REGIST_USER_ACCOUNT = SERVICE_DEVICES + "/user/users/registUser";
   String JUDGE_USER_EXIST =SERVICE_DEVICES+ "/user/users/judgeUserExist";


   //开放平台

   String OPEN_SERVER_PATH = "https://jeejiowebuser.qajeejio.com/user/sso/";

   //接口地址
   String LOGIN_PATH = OPEN_SERVER_PATH+"accountLogin";

}
