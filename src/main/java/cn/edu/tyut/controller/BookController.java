package cn.edu.tyut.controller;

import cn.edu.tyut.POJO.Book;
import cn.edu.tyut.POJO.User;
import cn.edu.tyut.entity.PageResult;
import cn.edu.tyut.entity.Result;
import cn.edu.tyut.service.BookService;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/book")
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

    @ResponseBody
    @RequestMapping("/findById")
    public Result<Book> findById(Integer id) {
        try {
            Book book = bookService.findById(id);
            if (book == null) {
                return new Result<>(false, "查询图书失败！");
            }
            return new Result<>(true, "查询图书成功！", book);
        } catch (Exception e) {
            return new Result<>(false, "查询图书失败！系统异常");
        }
    }

    @ResponseBody
    @RequestMapping("/borrowBook")
    public Result<Book> borrowBook(@NotNull Book book, @NotNull HttpSession httpSession) {
        String pName = ((User) httpSession.getAttribute("USER_SESSION")).getName();
        book.setBorrower(pName);
        try {
            Integer count = bookService.borrowBook(book);
            if (count != 1) {
                return new Result<>(false, "借阅图书失败！");
            }
            return new Result<>(true, "借阅图书成功！请到行政中心取书。");
        } catch (Exception e) {
            return new Result<>(false, "借阅图书失败！系统异常");
        }
    }
}
