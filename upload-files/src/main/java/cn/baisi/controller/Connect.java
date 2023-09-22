package cn.baisi.controller;

import cn.baisi.file.FileConnParamLoadHelper;
import cn.baisi.file.FileContext;
import cn.baisi.file.SSHParamModel;
import cn.baisi.utility.FtpUtil;
import com.jcraft.jsch.SftpException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.UUID;

@Controller
public class Connect {
    @PostMapping("/user/submit")
    public String submit(String nuser, @RequestParam("headPic") MultipartFile file) throws IOException {
        //获取上传的文件流
        InputStream inputStream = file.getInputStream();
        //获取上穿的文件名
        String originalFilename = file.getOriginalFilename();
        //截取上传文件的后缀
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        //拼接一个不重复的文件名子
        String s = UUID.randomUUID() + substring;
        //掉用之前写的工具类
        boolean submit = FtpUtil.submit(s, inputStream);
        System.out.println("上传的文件是"+s);
        return "abc";
    }
    @RequestMapping("/user/endurance")
    public String endurance() throws FileNotFoundException, SftpException {
        File file = new File("E:\\efg.txt");
        InputStream inputStream = new FileInputStream(file);

        SSHParamModel paramModel = FileConnParamLoadHelper.getParamModel();
        System.out.println(paramModel);
        System.out.println("ok"+paramModel);
        FileContext.getSshSession(paramModel);

        FileContext.upload(paramModel,file.getName(),inputStream);
        return "abc";
    }
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
