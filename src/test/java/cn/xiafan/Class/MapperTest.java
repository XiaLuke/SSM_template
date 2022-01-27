package cn.xiafan.Class;

import cn.xiafan.dao.StudentMapper;
import cn.xiafan.dao.TClassMapper;
import cn.xiafan.entity.Student;
import cn.xiafan.entity.TClass;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class MapperTest {
    @Autowired
    TClassMapper classMapper;
    @Autowired
    SqlSession sqlSession;

    @Test
    public void insert() {
        /*
         * //1创建SpringIOC容器 ApplicationContext ioc = new
         * ClassPathXmlApplicationContext("spring.xml"); //2从容器中获取mapper StudentMapper
         * bean = ioc.getBean(StudentMapper.class);
         */
        // 使用sqlSession批量插入数据
        sqlSession.getMapper(StudentMapper.class);
        for(int i= 0;i<100;i++) {
            String uid = UUID.randomUUID().toString().substring(0,5)+i;
            classMapper.insert(new TClass(uid,uid+uid));
        }
    }

}
