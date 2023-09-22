package cn.baisi.utility;

import com.jcraft.jsch.*;

import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

public class SftpUtil {
    //链接通道
    private ChannelSftp channelSftp;
    //链接session
    private Session session;
    //用户名
    private String username;
    //密码
    private String password;
    //ip地址
    private String host;
    //端口
    private int port;
    //创建对象时进行赋值
    public SftpUtil(String username, String password,  String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }
    //链接sftp服务器
    public void login(){
        try{
            JSch jSch = new JSch();
            Session session = jSch.getSession(username, host, port);
            if(null != password){
                session.setPassword(password);
            }
            //跳过密钥
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            //打开通道
            session.connect();
            //链接通道
            Channel channel = session.openChannel("sftp");
            channel.connect();
            //大转小强转
            channelSftp = (ChannelSftp)channel;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //关闭链接的方法
    public void logout(){
        if(null != channelSftp){
            //判断channelSftp是否还在链接,如果还是链接的话关闭链接
            if (channelSftp.isConnected()) channelSftp.disconnect();
        }
        if (null != session){
            //同上
            if (session.isConnected())channelSftp.disconnect();
        }
    }
    //上传文件的方法
    String suid = "";
    public void upload(String basePath, String dir, String sftpFileName, InputStream input) throws SftpException {
        try{
            //进入固定的文件路径
            channelSftp.cd(basePath);
            //进入不固定的文件里面,如果文件没有创建走catch
            channelSftp.cd(dir);
            //截取上传文件的后缀
            String substring = sftpFileName.substring(sftpFileName.lastIndexOf("."));
            //拼接一个不重复的文件名子
            suid = UUID.randomUUID()+substring;
            System.out.println("名字是"+ suid);
        }catch (Exception e) {
            //截取文件路径
            String[] split = dir.split("/");
            //遍历路经
            for (String s: split){
                try {
                    //进入
                    channelSftp.cd(s);
                } catch (SftpException ex) {
                    //创建文件
                    channelSftp.mkdir(s);
                    channelSftp.cd(s);
                }
            }
        }
        //上传文件
        channelSftp.put(input, suid);
    }
}
