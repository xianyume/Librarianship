package top.xianyume.librarianship.backend.service.impl;

import org.springframework.stereotype.Service;
import top.xianyume.librarianship.backend.mapper.FormMapper;
import top.xianyume.librarianship.backend.mapper.UserMapper;
import top.xianyume.librarianship.backend.pojo.Form;
import top.xianyume.librarianship.backend.service.FormService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    private final FormMapper formMapper;

    public FormServiceImpl(FormMapper formMapper) {
        this.formMapper = formMapper;
    }

    @Override
    public void create(Form form) {
        formMapper.add(form);
    }

    @Override
    public void update(Form form) {
        form.setUpdateTime(LocalDateTime.now());
        formMapper.update(form);
    }

    @Override
    public void delete(Integer id) {
        formMapper.delete(id);
    }

    @Override
    public Form findById(Integer id) {
        return formMapper.findById(id);
    }

    @Override
    public List<Form> list() {
        return formMapper.list();
    }
}
