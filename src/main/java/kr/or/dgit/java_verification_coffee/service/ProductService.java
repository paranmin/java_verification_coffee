package kr.or.dgit.java_verification_coffee.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.java_verification_coffee.dto.Product;
import kr.or.dgit.java_verification_coffee.util.MyBatisSqlSessionFactory;

public class ProductService {
	private static final Log log = LogFactory.getLog(ProductService.class);
	private static final ProductService instance = new ProductService();
	private final String namespace = "kr.or.dgit.java_verification_coffee.dao.ProductDao.";

	public static ProductService getInstance() {
		return instance;
	}

	private ProductService() {
	}

	public List<Product> selectProductByAll() {
		log.debug("selectProductByAll");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectProductByAll");
		}
	}

	public Product selectProductByCode(String code) {
		log.debug("selectProductByCode");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectProductByCode", code);
		}
	}
	
	public int insertProduct(Product product) {
		log.debug("insertProduct");
		int res = 0;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.insert(namespace + "insertProduct", product);
			sqlSession.commit();
		}
		return res;
	}

	public Product dupdateProduct(Product product) {
		log.debug("dupdateProduct");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "dupdateProduct", product);
		}
	}

	public int deleteProduct(Product product) {
		log.debug("deleteProduct");
		int res = 0;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.delete(namespace + "deleteProduct", product);
			sqlSession.commit();
		}
		return res;
	}
}
