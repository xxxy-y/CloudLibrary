package cn.edu.tyut.controller;

import cn.edu.tyut.entity.PageResult;
import cn.edu.tyut.service.BookService;
import com.alibaba.druid.stat.TableStat;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author 羊羊
 * @ClassName BookController
 * @SubmitTime 周六
 * @DATE 2024/1/6
 * @Time 13:10
 * @Package_Name cn.edu.tyut.controller
 */
@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/selectNewBooks")
    public ModelAndView selectNewBooks() {
        int pageNum = 1;
        int pageSize = 5;
        PageResult pageResult = bookService.selectNewBooks(pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books_new");
        modelAndView.addObject("pageResult", pageResult);
        return modelAndView;
    }
}
