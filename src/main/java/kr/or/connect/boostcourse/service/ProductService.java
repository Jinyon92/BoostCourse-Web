package kr.or.connect.boostcourse.service;

import java.util.List;

import kr.or.connect.boostcourse.dto.Product;

public interface ProductService {
	public static final Integer LIMIT = 4;
	public List<Product> getProducts(Integer start);
	public List<Product> getProductsByCategory(Integer categoryId, Integer start);
	public int getCount();
}
