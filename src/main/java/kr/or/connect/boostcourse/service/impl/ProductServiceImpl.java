package kr.or.connect.boostcourse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.boostcourse.dao.ProductDao;
import kr.or.connect.boostcourse.dto.DisplayInfo;
import kr.or.connect.boostcourse.dto.DisplayInfoImage;
import kr.or.connect.boostcourse.dto.Product;
import kr.or.connect.boostcourse.dto.ProductImages;
import kr.or.connect.boostcourse.dto.ProductPrices;
import kr.or.connect.boostcourse.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Product> getProducts(int start) {
		List<Product> list = productDao.selectAll(start, ProductService.LIMIT);
		return list;
	}

	@Override
	public List<Product> getProductsByCategory(int categoryId, int start) {
		List<Product> list = productDao.selectByCategory(categoryId, start, ProductService.LIMIT);
		return list;
	}

	@Override
	public int getCount() {
		return productDao.selectCount();
	}

	@Override
	public List<ProductPrices> getProductPrices(int displayInfoId) {
		return productDao.selectProductPrices(displayInfoId);
	}

	@Override
	public List<ProductImages> getProductImages(int displayInfoId) {
		return productDao.selectProductImages(displayInfoId);
	}

	@Override
	public DisplayInfoImage getDisplayInfoImage(int displayInfoId) {
		return productDao.selectDisplayInfoImage(displayInfoId);
	}

	@Override
	public DisplayInfo getDisplayInfo(int displayInfoId) {
		return productDao.selectDisplayInfo(displayInfoId);
	}
	

}
