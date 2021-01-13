package kr.or.connect.boostcourse.service;

import java.util.List;

import kr.or.connect.boostcourse.dto.Product;

public interface ProductService {
	public static final Integer LIMIT = 4;
	List<Product> getProducts(Integer start);
	List<Product> getProductsByCategory(Integer categoryId, Integer start);
	int getCount();
}
