package top.xianyume.librarianship.backend.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Book {
    private Integer id;
    private String name;
    private String author;
    private Integer form;
    private String description;
    private String publisher;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
