package kr.or.connect.boostcourse.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.boostcourse.dto.Promotion;
import kr.or.connect.boostcourse.service.PromotionService;

@RestController
@RequestMapping(path = "/api")
public class PromotionApiController {
	
	@Autowired
	PromotionService promotionService;
	
	@RequestMapping(value = "/promotions", method = RequestMethod.GET)
	public Map<String, Object> promotions(){
		List<Promotion> items = promotionService.getPromotions();
		
		Map<String, Object> map = new HashMap<>();
		map.put("items", items);
		
		return map;
	}
	
}
