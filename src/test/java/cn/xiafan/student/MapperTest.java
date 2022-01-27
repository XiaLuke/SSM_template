package cn.xiafan.student;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xiafan.dao.StudentMapper;
import cn.xiafan.entity.Student;

@RunWith(SpringJUnit4ClassRunner.class)
// 指定Spring配置文件路径
@ContextConfiguration(locations= {"classpath:spring.xml"})
public class MapperTest {
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void studentList() {
		/*
		 * //1创建SpringIOC容器 ApplicationContext ioc = new
		 * ClassPathXmlApplicationContext("spring.xml"); //2从容器中获取mapper StudentMapper
		 * bean = ioc.getBean(StudentMapper.class);
		 */
		// 使用sqlSession批量插入数据
		sqlSession.getMapper(StudentMapper.class);
		for(int i= 0;i<100;i++) {
			String uid = UUID.randomUUID().toString().substring(0,5)+i;
			studentMapper.insert(new Student(uid+"xxx","1254785411"+i,"dddd_1231_ggggg",uid+"@gmail.com",uid,uid));
		}
	}

}
