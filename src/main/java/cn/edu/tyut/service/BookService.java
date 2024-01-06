package cn.edu.tyut.service;

import cn.edu.tyut.POJO.Book;
import cn.edu.tyut.entity.PageResult;
import com.github.pagehelper.Page;

/**
 * @Author 羊羊
 * @ClassName BookService
 * @SubmitTime 周六
 * @DATE 2024/1/6
 * @Time 12:44
 * @Package_Name cn.edu.tyut.service
 */
public interface BookService {
    /**
     * Page对象是PageHelper分页插件提供的，Page对象继承ArrayList，在其中还封装了页码和总页数等信息
     * @return Page列表，其中的每一个元素为Book类型的
     */
    PageResult selectNewBooks(Integer pageNum, Integer pageSize);
}
