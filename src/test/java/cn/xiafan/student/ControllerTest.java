package cn.xiafan.student;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring.xml",
		"file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml" })
public class ControllerTest {
	// 传入springmvc的ioc，Autowired只能注入ioc容器内部的，所以需要WebAppConfiguration，将web中注入
	@Autowired
	WebApplicationContext context;
	// 虚拟mvc请求，获取处理结果
	MockMvc mockMvc;

	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testPage() throws Exception {
		// 模拟请求拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/student/list").param("1", "10"))
				.andReturn();
		// 请求成功后，请求与中有pageInfo
		MockHttpServletRequest request = result.getRequest();
		PageInfo attribute = (PageInfo) request.getAttribute("pageInfo");
		System.out.println("当前页数：" + attribute.getPageNum());
		System.out.println("总页码：" + attribute.getPages());
		System.out.println("总记录数：" + attribute.getTotal());
		// 连续页码
		int[] nums = attribute.getNavigatepageNums();
		for (int num : nums) {
			System.out.println(num);
		}
	}
}
