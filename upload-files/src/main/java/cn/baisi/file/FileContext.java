package cn.baisi.file;

import com.jcraft.jsch.*;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class FileContext {
    //链接通道
    private static ChannelSftp channelSftp;
    //链接session
    private static Session session;
    //线程安全的map集合
    private static ConcurrentHashMap<SSHParamModel, Session> sshSessionPool = null;
    private static Set<SSHParamModel> sshParamModelSet = null;
    private static String suid;

    public FileContext(SSHParamModel paramModel) {
        synchronized (FileContext.class){
            if (sshParamModelSet == null) sshParamModelSet = new HashSet<>();

            sshParamModelSet.add(paramModel);
            if (sshSessionPool == null){
                sshSessionPool = new ConcurrentHashMap<>();
                for (SSHParamModel sshParamModel : sshParamModelSet){
                    session = getSessionConnection(sshParamModel);
                    System.out.println("sftpConfig的构造方法中getSessionConnection:"+session);
                    sshSessionPool.put(sshParamModel,session);
                }
            }else {
                System.out.println("11111111111111111");
            }
        }
    }

    private static Session getSessionConnection(SSHParamModel sshParamModel){
        try{
            JSch jSch = new JSch();
            session = jSch.getSession(sshParamModel.getUsername(),
                    sshParamModel.getHost(), sshParamModel.getPort());
            if(null != sshParamModel.getPassword()) session.setPassword(sshParamModel.getPassword());

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
        return session;
    }

    public static  void  upload(SSHParamModel sshParamModel,String sftpFileName, InputStream input) throws SftpException {
       //固定的路径
        String basePath = sshParamModel.getBasePath();
        String bir = sshParamModel.getBir();
        try{
            channelSftp.cd(basePath);
            channelSftp.cd(bir);
            //截取上传文件的后缀
            String substring = sftpFileName.substring(sftpFileName.lastIndexOf("."));
            //拼接一个不重复的文件名子
            suid = UUID.randomUUID()+substring;
            System.out.println(suid);
        }catch (Exception e){
            String[] split = bir.split("/");
            for (String s: split) {
                try{
                    channelSftp.cd(s);
                }catch (Exception e1){
                    channelSftp.mkdir(s);
                    channelSftp.cd(s);
                }
            }
        }
        channelSftp.put(input ,suid);
    }

    public static void  getSshSession(SSHParamModel paramModel){
        //拿到之前存入的通道
        Session session1 = sshSessionPool.get(paramModel);
        synchronized (FileContext.class){
            //判断之前的通道是否过期
            if (null == session1 || !session1.isConnected()){
                if (sshSessionPool.containsKey(paramModel)){
                    //如果没有过期获取到之前发通道
                    session1 = getSessionConnection(paramModel);
                    //然后存入
                    sshSessionPool.put(paramModel,session1);
                }
            }else {
                System.out.println("==========");
            }
        }
    }
}