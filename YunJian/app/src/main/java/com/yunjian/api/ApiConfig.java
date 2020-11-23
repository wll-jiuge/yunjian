package com.yunjian.api;

/**
 * @author 吴立柳
 * @package com.yunjian.api
 * @date on 2020/9/26
 * @describe APi路径
 */
public class ApiConfig {
//    public static final String BASE_URL="http://47.112.247.115:10086";
    public static final String BASE_URL = "http://8.129.77.225:10086";
    //登录
    public static final String LOGIN="/sso/login";
    //获取验证码
    public static final String AUTHCODE="/sso/authcode";
    //任务-超时任务
    public static final String TASK_OVERTIME="/mb/task/overTimeTask";
    //任务-当前任务
    public static final String TASK_CURRENT="/mb/task/currentTask";
    //任务-已完成任务
    public static final String TASK_FINISHED="/mb/task/finishedTask";
//    巡检当前任务路径
    public static final String XUNJIAN_CURRENT="/mb/dailytask/currentTask";
//    巡检当前任务详细路径
    public static final String XUNJIAN_CURRENT_DETAIL="/mb/dailytask/currentTaskDetails";
//   巡检已完成路径
    public static final String XUNJIAN_FINISH="/mb/dailytask/finishedTask";
//    巡检已完成详细路径
    public static final String XUNJIAN_FINISH_DETAIL="/mb/dailytask/finishedTaskDetails";
//    巡检超时路径
    public static final String XUNJIAN_OVER="";
//    轮播图路径
    public static final String BANNER_RESOURCE="/mb/graph/select";
//    资源
    public static final String RESOURCE_IMAGE="/pc/resource/queryAllImage";

}
