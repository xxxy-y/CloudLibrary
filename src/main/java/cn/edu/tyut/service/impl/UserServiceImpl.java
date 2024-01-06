package cn.edu.tyut.service.impl;

import cn.edu.tyut.POJO.User;
import cn.edu.tyut.mapper.UserMapper;
import cn.edu.tyut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 羊羊
 * @ClassName UserServiceImpl
 * @SubmitTime 周五
 * @DATE 2024/1/5
 * @Time 21:19
 * @Package_Name cn.edu.tyut.service.impl
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 用户接口，通过user的用户账号和用户密码查询用户信息
     *
     * @param user 将用户账号和用户密码包装为User对象
     * @return 将查询到的数据库信息包装为User对象
     */
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
