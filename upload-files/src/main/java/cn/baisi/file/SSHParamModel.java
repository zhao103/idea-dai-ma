package cn.baisi.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//空参构造和全参构造
@NoArgsConstructor
@AllArgsConstructor
public class SSHParamModel {
    //用户名
    private String username;
    //密码
    private String password;
    //ip地址
    private String host;
    //端口
    private int port;
    //不动路径
    private String basePath;
    //可变路径
    private String bir;
}
