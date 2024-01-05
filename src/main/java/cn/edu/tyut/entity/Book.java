package cn.edu.tyut.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 羊羊
 * @ClassName Book
 * @SubmitTime 周五
 * @DATE 2024/1/5
 * @Time 20:53
 * @Package_Name cn.edu.tyut.entity
 */
@Data
public class Book implements Serializable {
    private Integer id;
    private String name;
    private String isbn;
    private String press;
    private String author;
    private Integer pagination;
    private Double price;
    private String uploadTime;
    private String statusB;
    private String borrow;
    private String borrowTime;
    private String returnTime;
}
