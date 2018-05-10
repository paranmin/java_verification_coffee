package kr.or.dgit.java_verification_coffee;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.java_verification_coffee.dto.Product;
import kr.or.dgit.java_verification_coffee.service.ProductService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTest {

	
	public void test1SelectProductByAll() {
		List<Product> list = ProductService.getInstance().selectProductByAll();
		assertNotNull(list);

		for (Product prd : list) {
			System.out.println(prd);
		}
	}

	
	public void test2SelectProductByCode() {
		Product product = ProductService.getInstance().selectProductByCode("A001");
		assertNotNull(product);

		System.out.println(product);
	}
}
