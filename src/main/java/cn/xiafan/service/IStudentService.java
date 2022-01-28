package cn.xiafan.service;

import java.util.List;

import cn.xiafan.entity.Student;

public interface IStudentService {
	List<Student> list();

    void save(Student student);

    boolean check(String realName);

    Student getOne(Integer id);

    void update(Student student);

}
