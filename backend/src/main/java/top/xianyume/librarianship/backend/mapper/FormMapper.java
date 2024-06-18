package top.xianyume.librarianship.backend.mapper;

import org.apache.ibatis.annotations.*;
import top.xianyume.librarianship.backend.pojo.Form;

import java.util.List;

@Mapper
public interface FormMapper {

    @Insert("insert into form(name, description, create_time, update_time)" +
            " values(#{name}, #{description}, NOW(), NOW())")
    void add(Form form);

    @Update("update form set name = #{name}, description = #{description}, update_time = NOW() where id = #{id}")
    void update(Form form);

    @Delete("delete from form where id = #{id}")
    void delete(Integer id);

    @Select("select * from form where id = #{id}")
    Form findById(Integer id);

    @Select("select * from form")
    List<Form> list();
}
