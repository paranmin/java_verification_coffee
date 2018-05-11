package kr.or.dgit.java_verification_coffee;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.java_verification_coffee.util.MyBatisSqlSessionFactory;


public class MyBatisSqlSessionFactoryTest {
	private static SqlSessionFactory factory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = MyBatisSqlSessionFactory.getSqlSessionFactory();
	}

	@AfterClass
	public static void tearDwonAfterClass() throws Exception {
		factory = null;
	}

	@Test
	public void testMyBatisSqlSessionFactory() {
		assertNotNull(factory.openSession());
	}

}
