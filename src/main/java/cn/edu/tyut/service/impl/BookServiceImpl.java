package cn.edu.tyut.service.impl;

import cn.edu.tyut.POJO.Book;
import cn.edu.tyut.entity.PageResult;
import cn.edu.tyut.mapper.BookMapper;
import cn.edu.tyut.service.BookService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author 羊羊
 * @ClassName BookServiceImpl
 * @SubmitTime 周六
 * @DATE 2024/1/6
 * @Time 12:44
 * @Package_Name cn.edu.tyut.service.impl
 * @Note 在 Java 中，@Transactional(rollbackFor = {}) 是一个注解（annotation），用于标记方法或类中的事务处理逻辑。
 * 它是 Spring 框架提供的注解之一。rollbackFor 是 @Transactional 注解的一个属性，用于指定事务应该在哪些异常发生时进行回滚操作。
 * rollbackFor 属性接受一个异常类型数组，表示当发生指定类型的异常时，事务将回滚。
 * 在 @Transactional(rollbackFor = {}) 中，rollbackFor = {} 表示没有指定特定的异常类型，即事务不会因为任何异常而回滚。
 * 这意味着在方法或类中使用 @Transactional 注解时，无论发生何种异常，事务都不会回滚。
 * 如果需要指定回滚的异常类型，可以在大括号 {} 中列出需要回滚的异常类型。
 * 例如，@Transactional(rollbackFor = {SQLException.class, IOException.class}) 表示当发生 SQLException 或 IOException 异常时，事务将回滚。
 * 通过使用 rollbackFor 属性，可以灵活地控制事务的回滚行为，以适应特定的业务需求和异常情况。
 */
@Service
@Transactional(rollbackFor = {SQLException.class, IOException.class})
public class BookServiceImpl implements BookService {
    private BookMapper bookMapper;

    @Autowired
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public PageResult selectNewBooks(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Book> page = bookMapper.selectNewBooks();
        return new PageResult(page.getTotal(), page.getResult());
    }
}
