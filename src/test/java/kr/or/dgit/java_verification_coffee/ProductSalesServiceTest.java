package kr.or.dgit.java_verification_coffee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import kr.or.dgit.java_verification_coffee.dto.Product;
import kr.or.dgit.java_verification_coffee.dto.ProductSales;
import kr.or.dgit.java_verification_coffee.service.ProductSalesService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductSalesServiceTest {

	public void test1InsertProductSale() {
		Product product = new Product();
		product.setCode("A001");
		ProductSales sale = new ProductSales(product, 5200, 150, 13);

		int res = ProductSalesService.getInstance().insertProductSale(sale);
		assertEquals(1, res);
	}

	public void test2UpdateProductSale() {
		Product product = new Product();
		product.setCode("A001");
		ProductSales sale = new ProductSales(product, 1, 4200, 250, 20);

		int res = ProductSalesService.getInstance().updateProductSale(sale);
		assertEquals(1, res);
	}

	public void test3DeleteProductSale() {
		ProductSales sale = new ProductSales();
		sale.setNo(2);

		int res = ProductSalesService.getInstance().deleteProductSale(sale);
		assertEquals(1, res);
	}

	public void test4SelectProductSalesBySell() {
		List<ProductSales> list = ProductSalesService.getInstance().selectProductSalesBySell();
		assertNotNull(list);
	}

	public void test5SelectProductSalesByMargin() {
		List<ProductSales> list = ProductSalesService.getInstance().selectProductSalesByMargin();
		assertNotNull(list);
	}
}
