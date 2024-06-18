package top.xianyume.librarianship.backend.service;

import top.xianyume.librarianship.backend.pojo.Form;

import java.util.List;

public interface FormService {

    void create(Form form);

    void update(Form form);

    void delete(Integer id);

    Form findById(Integer id);

    List<Form> list();



}
