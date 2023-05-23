package com.rlue.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rlue.usercenter.model.domain.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hgdc
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-05-13 12:41:16
 */
public interface UserService extends IService<User> {



    /**
     * 用户注册
     *
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @param userCode
     * @return
     */
    long userRegister(String userAccount, String userPassword, String checkPassword,String userCode);

    /**
     * 用户登录
     *
     * @param userAccount
     * @param userPassword
     * @param request
     * @return
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 请求用户注销
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);
}
