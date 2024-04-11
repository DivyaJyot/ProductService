package com.scaledivya.ProductService;

import com.scaledivya.ProductService.projection.ProductWithIdAndTitle;
import com.scaledivya.ProductService.repository.CategoryRepository;
import com.scaledivya.ProductService.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceApplicationTests {
	@Autowired // Dependency Injection
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void testQueries(){
		List<ProductWithIdAndTitle> list=productRepository.executeCustomeQuery();
		for(ProductWithIdAndTitle p:list){
			System.out.println("id= "+p.getId() +"  title="+ p.getTitle());

		}

	}

}
