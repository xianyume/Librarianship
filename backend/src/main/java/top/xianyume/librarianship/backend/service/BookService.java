package top.xianyume.librarianship.backend.service;

import top.xianyume.librarianship.backend.pojo.Book;
import top.xianyume.librarianship.backend.pojo.PageBean;

import java.util.List;

public interface BookService {

    void create(Book book);

    void update(Book book);

    void delete(Integer id);

    Book findById(Integer id);

    List<Book> list();

    PageBean<Book> pageInfo(Integer pageNumber, Integer pageSize, Integer formId);
}
