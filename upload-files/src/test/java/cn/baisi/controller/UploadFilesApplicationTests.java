package cn.baisi.controller;

import cn.baisi.file.FileConnParamLoadHelper;
import cn.baisi.file.FileContext;
import cn.baisi.file.SSHParamModel;
import cn.baisi.utility.SftpUtil;
import com.jcraft.jsch.SftpException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


@SpringBootTest
class UploadFilesApplicationTests {

    @Test
    void contextLoads() throws Exception {
        SftpUtil sftpUtil = new SftpUtil("root","123456","192.168.204.142",22);
        sftpUtil.login();
        File file = new File("E:\\abc.txt");
        InputStream inputStream = new FileInputStream(file);
        sftpUtil.upload("/sftp/mysftp/upload", "vore", file.getName(), inputStream);
        System.out.println("上传成功");
        sftpUtil.logout();
    }
    @Test
    public void show() throws Exception {
        File file = new File("E:\\efg.txt");
        InputStream inputStream = new FileInputStream(file);

        SSHParamModel paramModel = FileConnParamLoadHelper.getParamModel();
        System.out.println(paramModel);
        System.out.println("ok"+paramModel);
        FileContext.getSshSession(paramModel);

        FileContext.upload(paramModel,file.getName(),inputStream);
        System.out.println("文件上传成功");
    }

}
