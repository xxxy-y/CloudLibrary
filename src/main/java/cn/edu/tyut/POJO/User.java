package cn.edu.tyut.POJO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 羊羊
 * @ClassName User
 * @SubmitTime 周五
 * @DATE 2024/1/5
 * @Time 20:51
 * @Package_Name cn.edu.tyut.entity
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String role;
    private String statusU;
}
