package kr.or.connect.boostcourse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.boostcourse.dao.ProductDao;
import kr.or.connect.boostcourse.dto.Product;
import kr.or.connect.boostcourse.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Product> getProducts(Integer start) {
		List<Product> list = productDao.selectAll(start, ProductService.LIMIT);
		return list;
	}

	@Override
	public List<Product> getProductsByCategory(Integer categoryId, Integer start) {
		List<Product> list = productDao.selectByCategory(categoryId, start, ProductService.LIMIT);
		return list;
	}

	@Override
	public int getCount() {
		return productDao.selectCount();
	}
	

}
