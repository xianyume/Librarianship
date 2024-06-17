package top.xianyume.librarianship.backend.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Form {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
