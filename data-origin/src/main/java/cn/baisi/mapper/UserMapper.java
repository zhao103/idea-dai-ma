package cn.baisi.mapper;

import cn.baisi.entity.User;
import cn.baisi.enumeration.Mj;
import cn.baisi.note.DataSource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
@DataSource(Mj.master)
public interface UserMapper {
    //查询方法
    //@Select("select * from user")

    List<User> usersetAll();
}
