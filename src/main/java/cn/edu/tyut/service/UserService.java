package cn.edu.tyut.service;

import cn.edu.tyut.POJO.User;

/**
 * @Author 羊羊
 * @ClassName UserService
 * @SubmitTime 周五
 * @DATE 2024/1/5
 * @Time 21:14
 * @Package_Name cn.edu.tyut.service
 */
public interface UserService {
    /**
     * 用户接口，通过user的用户账号和用户密码查询用户信息
     * @param user 将用户账号和用户密码包装为User对象
     * @return 将查询到的数据库信息包装为User对象
     */
    User login(User user);
}
