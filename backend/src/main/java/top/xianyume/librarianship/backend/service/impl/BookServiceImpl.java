package top.xianyume.librarianship.backend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import top.xianyume.librarianship.backend.mapper.BookMapper;
import top.xianyume.librarianship.backend.pojo.Book;
import top.xianyume.librarianship.backend.pojo.PageBean;
import top.xianyume.librarianship.backend.service.BookService;
import top.xianyume.librarianship.backend.utils.ThreadLocalUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
    public PageBean<Book> pageInfo(Integer pageNumber, Integer pageSize, Integer formId) {

        PageBean<Book> pb = new PageBean<>();

        PageHelper.startPage(pageNumber,pageSize);

        List<Book> l = bookMapper.pageInfo(formId);
        //Page中提供了方法,可以获取PageHelper分页查询后 得到的总记录条数和当前页数据
        Page<Book> p = (Page<Book>) l;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());

        return pb;
    }
}
