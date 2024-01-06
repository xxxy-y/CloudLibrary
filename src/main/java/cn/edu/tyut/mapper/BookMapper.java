package cn.edu.tyut.mapper;

import cn.edu.tyut.POJO.Book;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Author 羊羊
 * @ClassName BookMapper
 * @SubmitTime 周六
 * @DATE 2024/1/6
 * @Time 12:32
 * @Package_Name cn.edu.tyut.mapper
 */
public interface BookMapper {
    /**
     * 按上架时间倒序查询出未下架的图书信息
     * @return Page继承ArrayList，是PageHelper分页插件提供的，它作为集合存放返回的对象，而且Page对象中还封装了页码和总页数等分页相关内容
     */
    @Results(value = {
            @Result(id = true, property = "id", column = "book_id"),
            @Result(property = "name", column = "book_name"),
            @Result(property = "isbn", column = "book_isbn"),
            @Result(property = "press", column = "book_press"),
            @Result(property = "author", column = "book_author"),
            @Result(property = "pagination", column = "book_pagination"),
            @Result(property = "price", column = "book_price"),
            @Result(property = "uploadTime", column = "book_uploadtime"),
            @Result(property = "statusB", column = "book_status"),
            @Result(property = "borrow", column = "book_borrow"),
            @Result(property = "borrowTime", column = "book_borrowtime"),
            @Result(property = "returnTime", column = "book_returntime")
    })
    @Select("SELECT * FROM book WHERE book_status != 3 ORDER BY book_uploadtime DESC")
    Page<Book> selectNewBooks();
}
