package cn.baisi.mapper;

import cn.baisi.entity.Stu;
import cn.baisi.entity.User;
import cn.baisi.enumeration.Mj;
import cn.baisi.note.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StuMapper {
    //查询方法
    //@Select("select * from stu")
    @DataSource(Mj.slave)
    List<Stu> StusetAll();
}
