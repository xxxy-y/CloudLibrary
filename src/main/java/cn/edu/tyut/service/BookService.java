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
     * @param pageNum 有几个分页
     * @param pageSize 每个分页能放几条数据
     * @return Page列表，其中的每个元素都为Book类型的
     */
    PageResult selectNewBooks(Integer pageNum, Integer pageSize);

    /**
     * 根据id查询书籍信息
     * @param id 传入的书籍id
     * @return 返回查询出来的book信息
     */
    Book findById(Integer id);

    /**
     * 使用editBook()来实现借阅书籍的状态变化
     * @param book 传入要借阅的书籍的信息
     * @return 返回是否借阅成功 1 成功 0 失败 比1 大代表有多个需要借阅的相同的书
     */
    Integer borrowBook(Book book);
}
