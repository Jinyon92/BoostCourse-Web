package kr.or.connect.boostcourse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.boostcourse.dao.PromotionDao;
import kr.or.connect.boostcourse.dto.Promotion;
import kr.or.connect.boostcourse.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {
	@Autowired
	PromotionDao promotionDao;
	
	@Override
	public List<Promotion> getPromotions() {
		List<Promotion> list = promotionDao.selectAll();
		return list;
	}

}
