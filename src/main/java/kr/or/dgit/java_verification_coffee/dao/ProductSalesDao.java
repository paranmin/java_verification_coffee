package kr.or.dgit.java_verification_coffee.dao;

import java.util.List;

import kr.or.dgit.java_verification_coffee.dto.ProductSales;

public interface ProductSalesDao {
	int insertProductSale(ProductSales sale);

	int updateProductSale(ProductSales sale);

	int deleteProductSale(ProductSales sale);

	List<ProductSales> selectProductSalesByAll();

	ProductSales selectProductSalesByCode(String code);
}
