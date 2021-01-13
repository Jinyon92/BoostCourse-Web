package kr.or.connect.boostcourse.service;

import java.util.List;

import kr.or.connect.boostcourse.dto.Category;

public interface CategoryService {
	public List<Category> getCategories();
	public int getCount(int categoryId);
}
