package com.chriscorp.ecommerce;

import com.chriscorp.ecommerce.model.Category;
import com.chriscorp.ecommerce.model.Product;
import com.chriscorp.ecommerce.model.SubCategory;
import com.chriscorp.ecommerce.model.User;
import com.chriscorp.ecommerce.repository.CategoryRepository;
import com.chriscorp.ecommerce.repository.ProductRepository;
import com.chriscorp.ecommerce.repository.SubCategoryRepository;
import com.chriscorp.ecommerce.secutiry.JWTAuthorization;
import com.chriscorp.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorization(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/user").permitAll().antMatchers("/h2-console/**")
					.permitAll().antMatchers("/").permitAll()
					.anyRequest().authenticated();
			http.csrf().disable();
			http.headers().frameOptions().disable();
		}
	}




	@Override
	public void run(String... args) throws Exception {
		//User
		User user1 = new User();
		user1.setUsername("Christian");
		user1.setPassword("admin");
		user1.setEmail("Christian.giraldo.1990@gmail.com");

		userService.postUser(user1);

		//Category
		Category category1 = new Category();
		category1.setName("Tecnologia");
		category1.setPhoto("adf44s-sd4f5sd-dsf4");

		Category category2 = new Category();
		category2.setName("Electrodomesticos");
		category2.setPhoto("adf44s-sd4f5sd-dsf4");

		Category category3 = new Category();
		category3.setName("Hogar");
		category3.setPhoto("adf44s-sd4f5sd-dsf4");

		Category category4 = new Category();
		category4.setName("Ropa");
		category4.setPhoto("adf44s-sd4f5sd-dsf4");

		categoryRepository.save(category1);
		categoryRepository.save(category2);
		categoryRepository.save(category3);
		categoryRepository.save(category4);

		//SubCategory
		SubCategory subCategory1 = new SubCategory();
		subCategory1.setName("Muebles");
		subCategory1.setCategory(category3);

		SubCategory subCategory2 = new SubCategory();
		subCategory2.setName("Televisores");
		subCategory2.setCategory(category2);

		SubCategory subCategory3 = new SubCategory();
		subCategory3.setName("Portatil Gamer");
		subCategory3.setCategory(category1);

		subCategoryRepository.save(subCategory1);
		subCategoryRepository.save(subCategory2);
		subCategoryRepository.save(subCategory3);

		//Product
		Product product1 = new Product();
		product1.setName("Lenovo 13''");
		product1.setDescription("Nuevo Lenovo con cosas cheveres");
		product1.setPhoto("asd255as56-asd56-654sad");
		product1.setPrice(1200000);
		product1.setWeight(30);
		product1.setSubCategory(subCategory1);

		Product product2 = new Product();
		product2.setName("TV OLED 58''");
		product2.setDescription("Nuevo televisor con la mejor pantalla y todo super casi que se salen las cosas del tv");
		product2.setPhoto("asd5as-as5da4sd-asd4asd");
		product2.setPrice(1200000);
		product2.setWeight(30);
		product2.setSubCategory(subCategory2);

		Product product3 = new Product();
		product3.setName("ASUS Gammer 15''");
		product3.setDescription("Nuevo portatil Gamer Asus GL-587W");
		product3.setPhoto("asdasd5-das470-wd5587");
		product3.setPrice(2200000);
		product3.setWeight(3);
		product3.setSubCategory(subCategory3);

		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);



	}
}