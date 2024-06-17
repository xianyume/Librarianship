package top.xianyume.librarianship.backend.service;

import top.xianyume.librarianship.backend.pojo.User;

public interface UserService {

    // 根据用户名查找用户
    User findByUserName(String username);

    // 注册
    void register(String username, String password);

    // 更新用户信息
    void update(User user);

    // 更新密码
    void updatePassword(String newPassword);

}
