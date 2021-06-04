package kr.or.connect.boostcourse.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.boostcourse.config.ApplicationConfig;

public class DaoTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		CommentDao commentDao = ac.getBean(CommentDao.class);
		System.out.println(commentDao.selectAvgScore(1));
	}

}
