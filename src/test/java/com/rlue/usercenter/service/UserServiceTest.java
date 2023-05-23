package com.rlue.usercenter.service;

import com.rlue.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author ZhuWeiFeng
 * @create 12:57
 * @Description 用户服务测试
 */

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("Rlue");
        user.setUserAccount("123");
        user.setAvatarUrl("https://cn.bing.com/images/search?view=detailV2&ccid=uN3iPMUA&id=7C96AEE0E4B2367DA558C19A10E1FB95936EA89A&thid=OIP.uN3iPMUATVK3KoD9CtoIpwAAAA&mediaurl=https%3a%2f%2fts1.cn.mm.bing.net%2fth%2fid%2fR-C.b8dde23cc5004d52b72a80fd0ada08a7%3frik%3dmqhuk5X74RCawQ%26riu%3dhttp%253a%252f%252fwww.qzqn8.com%252fwp-content%252fuploads%252f2020%252f02%252f2-9.jpg%26ehk%3duQhQFxBRle1Na4eVX1sNfaScN9RQDLZ0ekwjRg0vxuA%253d%26risl%3d%26pid%3dImgRaw%26r%3d0&exph=400&expw=400&q=%e5%a4%b4%e5%83%8f&simid=608036712401285825&FORM=IRPRST&ck=BCE29A2C757CA8117ECE171243EFBF41&selectedIndex=28");
        user.setGender(0);
        user.setUserPassword("123");
        user.setPhone("123");
        user.setEmail("123");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "rule11";
        String userPassword = "123456";
        String checkPassword = "";
        String userCode = "213";
        long result = userService.userRegister(userAccount, userPassword, checkPassword,userCode);
        Assertions.assertEquals(-1, result);
        userAccount = "ru";
        result = userService.userRegister(userAccount, userPassword, checkPassword,userCode);
        Assertions.assertEquals(-1, result);
        userAccount = "rule11";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword,userCode);
        Assertions.assertEquals(-1, result);
        userAccount = "ru le1";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword,userCode);
        Assertions.assertEquals(-1, result);
        userAccount = "rule11";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword,userCode);
        Assertions.assertEquals(-1, result);
        userAccount = "rlue";
        result = userService.userRegister(userAccount, userPassword, checkPassword,userCode);
        Assertions.assertEquals(result -1,result);
    }
}