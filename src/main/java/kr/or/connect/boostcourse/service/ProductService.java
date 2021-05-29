package kr.or.connect.boostcourse.service;

import java.util.List;

import kr.or.connect.boostcourse.dto.DisplayInfo;
import kr.or.connect.boostcourse.dto.DisplayInfoImage;
import kr.or.connect.boostcourse.dto.Product;
import kr.or.connect.boostcourse.dto.ProductImages;
import kr.or.connect.boostcourse.dto.ProductPrices;

public interface ProductService {
	public static final Integer LIMIT = 4;
	List<Product> getProducts(int start);
	List<Product> getProductsByCategory(int categoryId, int start);
	List<ProductPrices> getProductPrices(int displayInfoId);
	List<ProductImages> getProductImages(int displayInfoId);
	DisplayInfoImage getDisplayInfoImage(int displayInfoId);
	DisplayInfo getDisplayInfo(int displayInfoId);
	int getCount();
}
