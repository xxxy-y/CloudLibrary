package cn.edu.tyut.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 羊羊
 * @ClassName Record
 * @SubmitTime 周五
 * @DATE 2024/1/5
 * @Time 20:56
 * @Package_Name cn.edu.tyut.entity
 */
@Data
public class Record implements Serializable {
    private Integer id;
    private String bookName;
    private String borrower;
    private String borrowTime;
    private String remandTime;
}
