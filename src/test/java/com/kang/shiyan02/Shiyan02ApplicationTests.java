package com.kang.shiyan02;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.shiyan02.dao.s_schoolDao;
import com.kang.shiyan02.dao.s_studentDao;
import com.kang.shiyan02.domain.User;
import com.kang.shiyan02.domain.s_student;
import com.kang.shiyan02.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Shiyan02ApplicationTests {

	@Resource
private s_schoolDao schoolDao;

	@Resource
	private s_studentDao studentDao;

	@Resource
	private UserService userService;

	@Test
	void contextLoads() {

		System.out.println(schoolDao.selectList(null));
		System.out.println(studentDao.selectList(null));
	}

	@Test
	void testlogin()
	{
		User user = new User();
		user.setPassword("123");
		user.setUsername("123");
		System.out.println(userService.login(user));

	}
     @Test
	public List<s_student> selectByPage(int currentPage, int pageSize) {
		IPage page=new Page(2,5);
		IPage iPage = studentDao.selectPage(page, null);
//		studentDao.selectPage(page,null);
		System.out.println("当前页码"+iPage.getCurrent());
		System.out.println("当前页面条数："+iPage.getSize());
		System.out.println(iPage.getRecords());
		System.out.println(iPage.getTotal());
//        iPage.getRecords()
		List<s_student> records = iPage.getRecords();
		 System.out.println(records);
		return records;
	}




}
