package com.yunjian.api;

/**
 * @author 吴立柳
 * @package com.yunjian.api
 * @date on 2020/9/26
 * @describe APi路径
 */
public class ApiConfig {
    public static final String BASE_URL="http://8.129.77.225:10086";
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
//   巡检已完成路径
    public static final String XUNJIAN_FINISH="";
//    巡检超时路径
    public static final String XUNJIAN_OVER="";
//    轮播图路径
    public static final String BANNER_RESOURCE="/mb/graph/select";
//    日志路径
    public static final String RESOURCE_IMAGE="/pc/resource/queryAllImag";
    //用户帐号信息
    public static final String USER_ACCOUNT="/mb/user/selectAccountByUserId";
    //用户基本信息
    public static final String USER_BASIC="/mb/user/selectByUserId";
    //用户部门信息
    public static final String USER_DEPTMENT="/mb/user/selectDeptByUserId";
    //用户班组信息
    public static final String USER_TEAM="/mb/user/selectTeamByUserId";
}
