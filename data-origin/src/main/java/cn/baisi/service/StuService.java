package cn.baisi.service;

import cn.baisi.entity.Stu;
import cn.baisi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StuService {
    //查询方法
    List<Stu> StusetAll();
}
