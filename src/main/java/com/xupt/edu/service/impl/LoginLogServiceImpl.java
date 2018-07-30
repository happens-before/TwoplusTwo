package com.xupt.edu.service.impl;


import com.xupt.edu.mapper.LoginLogMapper;
import com.xupt.edu.pojo.LoginLog;
import com.xupt.edu.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    public LoginLogMapper loginLogDao;

    public boolean addLog(LoginLog log) {

        if(loginLogDao.insert(log)>0){
            return true;
        }else {
            return false;
        }
    }
}
