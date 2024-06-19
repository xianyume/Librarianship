package top.xianyume.librarianship.backend.service.impl;

import org.springframework.stereotype.Service;
import top.xianyume.librarianship.backend.mapper.BookMapper;
import top.xianyume.librarianship.backend.pojo.Book;
import top.xianyume.librarianship.backend.service.BookService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public void create(Book book) {
        bookMapper.add(book);
    }

    @Override
    public void update(Book book) {
        book.setUpdateTime(LocalDateTime.now());
        bookMapper.update(book);
    }

    @Override
    public void delete(Integer id) {
        bookMapper.delete(id);
    }

    @Override
    public Book findById(Integer id) {
        return bookMapper.findById(id);
    }

    @Override
    public List<Book> list() {
        return bookMapper.list();
    }

    @Override
    public List<Book> pageInfo(Integer formId) {

        try {
            if (formId != 1) {
                return bookMapper.pageInfoByFormId(formId);
            }
            else {
                return bookMapper.pageInfo();
            }
        } catch (Exception _) {

        }
        return bookMapper.pageInfo();
    }
}
