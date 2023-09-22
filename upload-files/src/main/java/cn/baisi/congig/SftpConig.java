package cn.baisi.congig;

import cn.baisi.file.FileConnParamLoadHelper;
import cn.baisi.file.FileContext;
import cn.baisi.file.SSHParamModel;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SftpConig {
    @Bean
    @ConfigurationProperties("file.connect.sftp.param")
    public SSHParamModel sshParamModel(){
        return new SSHParamModel();
    }
    @Bean
    public FileConnParamLoadHelper fileConnParamLoadHelper(){

        return new FileConnParamLoadHelper(sshParamModel());
    }
    @Bean
    public FileContext fileContext(){
        return new FileContext(sshParamModel());
    }
}
