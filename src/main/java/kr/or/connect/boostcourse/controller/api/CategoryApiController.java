package kr.or.connect.boostcourse.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.boostcourse.dto.Category;
import kr.or.connect.boostcourse.service.CategoryService;

@RestController
@RequestMapping(path = "/api")
public class CategoryApiController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public Map<String, Object> categories() {
		List<Category> items = categoryService.getCategories();
		
		Map<String, Object> map = new HashMap<>();
		map.put("items", items);
		
		return map;
	}
}
