package cn.edu.tyut.entity;

import lombok.Data;
import org.jetbrains.annotations.Contract;

import java.io.Serializable;

/**
 * @Author 羊羊
 * @ClassName Result
 * @SubmitTime 周日
 * @DATE 2024/1/7
 * @Time 18:04
 * @Package_Name cn.edu.tyut.entity
 */
@Data
public class Result<T> implements Serializable {
    private boolean success;
    private String message;
    private T data;

    @Contract(pure = true)
    public Result(Boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    @Contract(pure = true)
    public Result(Boolean success, String message, T data){
        this.message = message;
        this.success = success;
        this.data = data;
    }
}