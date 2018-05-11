package kr.or.dgit.java_verification_coffee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.java_verification_coffee.dto.Product;
import kr.or.dgit.java_verification_coffee.dto.ProductSales;
import kr.or.dgit.java_verification_coffee.service.ProductSalesService;
import kr.or.dgit.java_verification_coffee.service.ProductService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleDaoTest {

	@Test
	public void testAselectSaleByAll() {
		List<ProductSales> list = ProductSalesService.getInstance().selectProductSalesByAll();
		assertNotNull(list);
	}

	@Test
	public void testBselectSaleByNo() {
		ProductSales sale = ProductSalesService.getInstance().selectProductSalesByCode("A001");
		assertNotNull(sale);
	}

	@Test
	public void testCinsertProduct() {
		int res = ProductService.getInstance().insertProduct(new Product("C001", "바닐라쉐이크"));
		assertEquals(1, res);
	}

	@Test
	public void testDupdateProduct() {
		Product product = ProductService.getInstance().dupdateProduct(new Product("C001", "바닐라쉐이크"));
		assertNotNull(product);
	}

	@Test
	public void testEdeleteProduct() {
		int res = ProductService.getInstance().deleteProduct(new Product("C001", "바닐라쉐이크"));
		assertEquals(1, res);
	}

	@Test
	public void testFcallSaleDetail() {
		List<ProductSales> list = ProductSalesService.getInstance().selectProductSalesBySell();
		assertNotNull(list);
	}

	@Test
	public void testGcallgetTotal() {
		List<Map<String, Object>> maps = ProductSalesService.getInstance().getTotal();
		assertNotNull(maps);
	}
}
