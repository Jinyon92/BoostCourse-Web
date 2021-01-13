package kr.or.connect.boostcourse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.boostcourse.dao.CategoryDao;
import kr.or.connect.boostcourse.dto.Category;
import kr.or.connect.boostcourse.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	@Transactional
	public List<Category> getCategories() {
		List<Category> list = categoryDao.selectAll();
		return list;
	}

	@Override
	public int getCount(int categoryId) {
		return categoryDao.selectCount(categoryId);
	}

}
