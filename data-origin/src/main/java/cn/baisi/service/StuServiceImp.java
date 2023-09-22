package cn.baisi.service;

import cn.baisi.entity.Stu;
import cn.baisi.entity.User;
import cn.baisi.mapper.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImp implements StuService{
    @Autowired
    private StuMapper stumapper;

    public List<Stu> StusetAll() {

        return stumapper.StusetAll();
    }
}
