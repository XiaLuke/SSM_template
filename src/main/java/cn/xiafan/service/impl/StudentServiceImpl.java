package cn.xiafan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xiafan.dao.StudentMapper;
import cn.xiafan.entity.Student;
import cn.xiafan.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	StudentMapper studentMapper;
	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		return studentMapper.selectAll();
	}

    @Override
    public void save(Student student) {
        studentMapper.insert(student);
    }

	@Override
	public boolean check(String realName) {
		Integer count = studentMapper.check(realName);
		return count == 0;
	}

	@Override
	public Student getOne(Integer id) {
		return studentMapper.getOne(id);
	}

	@Override
	public void update(Student student) {
		studentMapper.update(student);
	}

}
