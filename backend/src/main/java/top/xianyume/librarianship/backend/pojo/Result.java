package top.xianyume.librarianship.backend.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//统一响应结果
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    // 1 成功
    // 0 失败
    private Integer code;
    // 返回提示信息
    private String msg;
    // 返回数据
    private T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setMsg("操作成功");
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.setMsg("操作成功");
        result.data = object;
        result.code = 1;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.msg = msg;
        result.code = 0;
        return result;
    }

}