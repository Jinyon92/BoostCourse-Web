package kr.or.connect.boostcourse.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.boostcourse.dto.Comments;
import kr.or.connect.boostcourse.dto.DisplayInfo;
import kr.or.connect.boostcourse.dto.DisplayInfoImage;
import kr.or.connect.boostcourse.dto.Product;
import kr.or.connect.boostcourse.dto.ProductImages;
import kr.or.connect.boostcourse.dto.ProductPrices;
import kr.or.connect.boostcourse.service.CategoryService;
import kr.or.connect.boostcourse.service.CommentService;
import kr.or.connect.boostcourse.service.ProductService;

@RestController
@RequestMapping(path = "/api")
public class ProductApiController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CommentService commentService;
	
	@GetMapping(value="/products")
	public Map<String, Object> products(@RequestParam(defaultValue = "0")int start) {
		List<Product> items = productService.getProducts(start);
		int totalCount = productService.getCount();
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("items", items);
		
		return map;
	}
	
	@RequestMapping(value = "/products", params = {"start", "categoryId"}, method = RequestMethod.GET)
	public Map<String, Object> productsByCategory(@RequestParam(name="start") int start,
			@RequestParam(name="categoryId")int categoryId) {
		
		List<Product> items = productService.getProductsByCategory(categoryId, start);
		int totalCount = categoryService.getCount(categoryId);
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("items", items);
		
		return map;
	}
	
	/* products/{displayInfoId} */
	@GetMapping(value = "/products/{displayInfoId}")
	public Map<String, Object> productsByDisplayInfoId(@PathVariable("displayInfoId") int displayInfoId){
		List<ProductPrices> productPrices = productService.getProductPrices(displayInfoId);
		List<ProductImages> productImages = productService.getProductImages(displayInfoId);
		DisplayInfo displayInfo = productService.getDisplayInfo(displayInfoId);
		DisplayInfoImage displayInfoImage = productService.getDisplayInfoImage(displayInfoId);
		List<Comments> comments = commentService.getComments(displayInfoId);
		double averageScore = commentService.getAvgScore(displayInfoId);
		
		Map<String, Object> map = new HashMap<>();
		map.put("averageScore", averageScore);
		map.put("comments", comments);
		map.put("displayInfo", displayInfo);
		map.put("displayInfoImage", displayInfoImage);
		map.put("productImages", productImages);
		map.put("productPrices", productPrices);
		
		return map;
	}
	
}
