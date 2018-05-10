package kr.or.dgit.java_verification_coffee;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.java_verification_coffee.dto.Product;
import kr.or.dgit.java_verification_coffee.dto.ProductSales;
import kr.or.dgit.java_verification_coffee.service.ProductSalesService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductSalesServiceTest {

	@Test
	public void test1InsertProductSale() {
		Product product = new Product();
		product.setCode("A001");
		ProductSales sale = new ProductSales(product, 5200, 150, 13);

		int res = ProductSalesService.getInstance().insertProductSale(sale);
		assertEquals(1, res);
	}

}
