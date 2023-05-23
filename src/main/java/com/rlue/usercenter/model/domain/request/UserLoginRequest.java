package com.rlue.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZhuWeiFeng
 * @create 0:01
 * @Description 用户登录请求体
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -6974822464264861480L;

    private String userAccount;

    private String userPassword;



}
