package top.xianyume.librarianship.backend.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;
import top.xianyume.librarianship.backend.pojo.Book;
import top.xianyume.librarianship.backend.pojo.PageBean;
import top.xianyume.librarianship.backend.pojo.Result;
import top.xianyume.librarianship.backend.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public Result<Void> create(@RequestBody Book book){
        bookService.create(book);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Book>> list(){
        List<Book> book = bookService.list();
        return Result.success(book);
    }

    @PutMapping("/update")
    public Result<Void> update(@RequestBody Book book){
        bookService.update(book);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result<Void> delete(Integer id){
        bookService.delete(id);
        return Result.success();
    }

    @GetMapping("/info")
    public Result<Book> info(Integer id){
        Book book = bookService.findById(id);
        return Result.success(book);
    }

    @GetMapping("/pageInfo")
    public Result<PageBean<Book>> pageInfo(Integer pageNumber,
                                           Integer pageSize,
                                           @RequestParam(required = false) Integer formId
    ) {
        PageBean<Book> pb =  bookService.pageInfo(pageNumber, pageSize, formId);
        return Result.success(pb);

    }
}
