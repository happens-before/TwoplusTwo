package com.xupt.edu.service;


import com.xupt.edu.pojo.LoginLog;

public interface LoginLogService {


    /**
     * 插入一条登录日志
     */
    boolean addLog(LoginLog log);
}
