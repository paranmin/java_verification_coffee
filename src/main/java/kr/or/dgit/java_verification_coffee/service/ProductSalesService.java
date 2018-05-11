package kr.or.dgit.java_verification_coffee.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.java_verification_coffee.dto.ProductSales;
import kr.or.dgit.java_verification_coffee.util.MyBatisSqlSessionFactory;

public class ProductSalesService {
	private static final Log log = LogFactory.getLog(ProductSalesService.class);
	private static final ProductSalesService instance = new ProductSalesService();
	private final String namespace = "kr.or.dgit.java_verification_coffee.dao.ProductSalesDao.";

	public static ProductSalesService getInstance() {
		return instance;
	}

	private ProductSalesService() {
	}

	public int insertProductSale(ProductSales sale) {
		log.debug("insertProductSale");
		int res = 0;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.insert(namespace + "insertProductSale", sale);
			sqlSession.commit();
		}
		return res;
	}

	public int updateProductSale(ProductSales sale) {
		log.debug("updateProductSale");
		int res = 0;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.update(namespace + "updateProductSale", sale);
			sqlSession.commit();
		}
		return res;
	}

	public int deleteProductSale(ProductSales sale) {
		log.debug("deleteProductSale");
		int res = 0;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.delete(namespace + "deleteProductSale", sale);
			sqlSession.commit();
		}
		return res;
	}

	public List<ProductSales> selectProductSalesByAll() {
		log.debug("selectProductSalesByAll");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectProductSalesByAll");
		}
	}

	public List<ProductSales> selectProductSalesBySell() {
		log.debug("selectProductSalesBySell");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectProductSalesBySell");
		}
	}

	public List<ProductSales> selectProductSalesByMargin() {
		log.debug("selectProductSalesByMargin");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectProductSalesByMargin");
		}
	}

	public ProductSales selectProductSalesByCode(String code) {
		log.debug("selectProductSalesByCode");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectProductSalesByCode", code);
		}
	}

	public List<Map<String, Object>> getTotal() {
		log.debug("getTotal");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "getTotal");
		}
	}
}
