package cn.xiafan.dao;

import cn.xiafan.entity.Student;
import cn.xiafan.entity.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
	/*
	 * long countByExample(StudentExample example);
	 * 
	 * int deleteByExample(StudentExample example);
	 * 
	 * int insert(Student record);
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
}