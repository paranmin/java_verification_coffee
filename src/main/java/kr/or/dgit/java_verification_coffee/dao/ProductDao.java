package kr.or.dgit.java_verification_coffee.dao;

import java.util.List;

import kr.or.dgit.java_verification_coffee.dto.Product;

public interface ProductDao {
	List<Product> selectProductByAll();

	Product selectProductByCode(String code);

	int insertProduct(Product product);

	Product dupdateProduct(Product product);

	int deleteProduct(Product product);
}
