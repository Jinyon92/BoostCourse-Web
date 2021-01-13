package kr.or.connect.boostcourse.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.boostcourse.dto.Product;
import kr.or.connect.boostcourse.service.CategoryService;
import kr.or.connect.boostcourse.service.ProductService;

@RestController
@RequestMapping(path = "/api")
public class ProductApiController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/products", params = "start", method = RequestMethod.GET)
	public Map<String, Object> products(@RequestParam(name = "start", required = false, defaultValue = "0")int start) {
		List<Product> items = productService.getProducts(start);
		int totalCount = productService.getCount();
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("items", items);
		
		return map;
	}
	
	@RequestMapping(value = "/products", params = {"start", "categoryId"}, method = RequestMethod.GET)
	public Map<String, Object> productsByCategory(@RequestParam(name="start", required = true) int start,
			@RequestParam(name="categoryId", required = true)int categoryId) {
		
		List<Product> items = productService.getProductsByCategory(categoryId, start);
		int totalCount = categoryService.getCount(categoryId);
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("items", items);
		
		return map;
	}
}
