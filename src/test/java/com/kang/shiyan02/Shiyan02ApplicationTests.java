package com.kang.shiyan02;

import com.kang.shiyan02.dao.s_schoolDao;
import com.kang.shiyan02.dao.s_studentDao;
import com.kang.shiyan02.domain.s_student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Shiyan02ApplicationTests {

	@Resource
private s_schoolDao schoolDao;

	@Resource
	private s_studentDao studentDao;

	@Test
	void contextLoads() {

		System.out.println(schoolDao.selectList(null));
		System.out.println(studentDao.selectList(null));
	}

}
