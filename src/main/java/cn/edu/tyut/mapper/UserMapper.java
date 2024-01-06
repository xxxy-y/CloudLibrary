package cn.edu.tyut.mapper;

import cn.edu.tyut.POJO.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Author 羊羊
 * @ClassName UserMapper
 * @SubmitTime 周五
 * @DATE 2024/1/5
 * @Time 21:00
 * @Package_Name cn.edu.tyut.mapper
 */
public interface UserMapper {
    /**
     * 通过用户账号和用户密码来查询用户
     * @param user 将传入的参数包装成User对象
     * @return 返回为查询出来的User对象
     */
    @Results(id = "userMap", value = {
            @Result(id = true, property = "id", column = "user_id"),
            @Result(property = "name", column = "user_name"),
            @Result(property = "password", column = "user_password"),
            @Result(property = "email", column = "user_email"),
            @Result(property = "role", column = "user_role"),
            @Result(property = "statusU", column = "user_status")
    })
    @Select("SELECT * FROM user WHERE user_email=#{email} AND user_password=#{password} AND user_status!='1'")
    User login(User user);
}
