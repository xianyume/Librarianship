package top.xianyume.librarianship.backend;

import org.junit.jupiter.api.Test;
import top.xianyume.librarianship.backend.utils.Md5Util;

public class MD5Test {

    @Test
    public void md5Test() {
        String text = "123456";
        String md5String = Md5Util.getMD5String(text);
        System.out.println(md5String);
    }
}
