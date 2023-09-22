package cn.baisi.utility;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

public class FtpUtil {
    //地址
    private static final String FTP_ADDRESS = "192.168.204.132";
    //服务器端口号
    private static final int FTP_PORT = 21;
    //用户名字
    private static final String FTP_NAME = "good";
    //用户密码
    private static final String FTP_PASSWORD = "123456";
    //存储的路径
    private static final String FTP_BASEPATH = "/home/good/text";

    //方法
    public static boolean submit(String fuilname , InputStream input){
        boolean sutr = false;
        //创建ftp客户端
        FTPClient ftpClient = new FTPClient();

        try {
            //链接服务器
            ftpClient.connect(FTP_ADDRESS,FTP_PORT);
            //登录
            ftpClient.login(FTP_NAME,FTP_PASSWORD);
            int replyCode = ftpClient.getReplyCode();
            //判断如果没有链接上就断开链接
            if(!FTPReply.isPositiveCompletion(replyCode)){
                ftpClient.disconnect();
                return false;
            }
            // 设置文件类型 二进制的文件
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            //创建文件夹
            ftpClient.makeDirectory(FTP_BASEPATH);
            //设置上传目录
            ftpClient.changeWorkingDirectory(FTP_BASEPATH);
            //看看端口是否被占用,如果被占用就换端口
            ftpClient.enterLocalPassiveMode();
            //存储文件,返回值如果为true则上传成功
            System.out.println(ftpClient.storeFile(fuilname, input));
            //获取相应状态
            System.out.println(ftpClient.getReplyString());
            //关闭流,注销客户端
            input.close();
            ftpClient.logout();
            sutr = true;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (ftpClient.isConnected()){
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sutr;
    }
}