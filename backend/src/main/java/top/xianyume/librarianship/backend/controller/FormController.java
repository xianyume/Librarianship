package top.xianyume.librarianship.backend.controller;

import org.springframework.web.bind.annotation.*;
import top.xianyume.librarianship.backend.pojo.Form;
import top.xianyume.librarianship.backend.pojo.Result;
import top.xianyume.librarianship.backend.service.FormService;

import java.util.List;

@RestController
@RequestMapping("/form")
public class FormController {
    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping("/create")
    public Result<Void> create(@RequestBody Form form){
        formService.create(form);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Form>> list(){
        List<Form> form = formService.list();
        return Result.success(form);
    }

    @PutMapping("/update")
    public Result<Void> update(@RequestBody Form form){
        formService.update(form);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result<Void> delete(Integer id){
        formService.delete(id);
        return Result.success();
    }

    @GetMapping("/info")
    public Result<Form> info(Integer id){
        Form form = formService.findById(id);
        return Result.success(form);
    }
}
