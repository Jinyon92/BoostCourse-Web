package kr.or.connect.boostcourse.service;

import java.util.List;

import kr.or.connect.boostcourse.dto.Category;

public interface CategoryService {
	List<Category> getCategories();
	int getCount(int categoryId);
}
