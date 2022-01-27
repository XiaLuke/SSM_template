package cn.xiafan.service.impl;

import cn.xiafan.dao.TClassMapper;
import cn.xiafan.entity.TClass;
import cn.xiafan.service.ITClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TClassServiceImpl implements ITClassService {
    @Autowired
    private TClassMapper tClassMapper;
    @Override
    public List<TClass> list() {
        return tClassMapper.list();
    }
}
