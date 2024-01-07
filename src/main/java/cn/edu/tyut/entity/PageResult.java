package cn.edu.tyut.entity;

import lombok.Data;
import org.jetbrains.annotations.Contract;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 羊羊
 * @ClassName PageResult
 * @SubmitTime 周六
 * @DATE 2024/1/6
 * @Time 12:47
 * @Package_Name cn.edu.tyut.entity
 */
@Data
public class PageResult implements Serializable {
    private long total;
    private List<?> rows;

    @Contract(pure = true)
    public PageResult(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }
}
