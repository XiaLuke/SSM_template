package cn.xiafan.utils.SpringTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xiafan.dao.StudentMapper;

@RunWith(SpringJUnit4ClassRunner.class)
// 指定Spring配置文件路径
@ContextConfiguration(locations= {"classpath:spring.xml"})
public class MapperTest {
	@Autowired
	StudentMapper studentMapper;
	@Test
	public void studentList() {
		/*
		 * //1创建SpringIOC容器 ApplicationContext ioc = new
		 * ClassPathXmlApplicationContext("spring.xml"); //2从容器中获取mapper StudentMapper
		 * bean = ioc.getBean(StudentMapper.class);
		 */
		System.out.println(studentMapper);
	
	}

}
