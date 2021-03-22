package com.allen.service;

import com.allen.entity.User;

/**
 * @author tanla
 * @version 1.0
 * @description todo
 * @date 2021/1/23 23:07
 **/
public interface UserOperation {
    User registerUser(String userName,String passWord);
}
