package top.xianyume.librarianship.backend.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
