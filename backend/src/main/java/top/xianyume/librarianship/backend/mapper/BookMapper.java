package top.xianyume.librarianship.backend.mapper;

import org.apache.ibatis.annotations.*;
import top.xianyume.librarianship.backend.pojo.Book;

import java.util.List;

@Mapper
public interface BookMapper {

    @Insert("insert into book(name, author, form, description, publisher, create_time, update_time)" +
            " values(#{name}, #{author}, #{form}, #{description}, #{publisher}, NOW(), NOW())")
    void add(Book book);

    @Update("update book set name = #{name}, author = #{author}, form = #{form}," +
            "description = #{description}, publisher = #{publisher} , update_time = NOW()" +
            "where id = #{id}")
    void update(Book book);

    @Delete("delete from book where id = #{id}")
    void delete(Integer id);

    @Select("select * from book where id = #{id}")
    Book findById(Integer id);

    @Select("select * from book")
    List<Book> list();

    @Select("select * from book where form = #{formId}")
    List<Book> pageInfoByFormId(Integer formId);

    @Select("select * from book")
    List<Book> pageInfo();
}
