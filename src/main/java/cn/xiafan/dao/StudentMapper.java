package cn.xiafan.dao;

import cn.xiafan.entity.Student;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
	/*
	 * long countByExample(StudentExample example);
	 * 
	 * int deleteByExample(StudentExample example);
	 * 
	 * 
	 * 
	 * int insertSelective(Student record);
	 * 
	 * List<Student> selectByExample(StudentExample example);
	 * 
	 * int updateByExampleSelective(@Param("record") Student
	 * record, @Param("example") StudentExample example);
	 * 
	 * int updateByExample(@Param("record") Student record, @Param("example")
	 * StudentExample example);
	 */
    
    List<Student> selectAll();
    
    int insert(Student record);

    Integer check(@Param("realName") String realName);

	Student getOne(@Param("id") Integer id);

	void update(@Param("student") Student student);
}