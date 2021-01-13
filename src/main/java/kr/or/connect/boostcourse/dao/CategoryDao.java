package kr.or.connect.boostcourse.dao;

import static kr.or.connect.boostcourse.dao.CategoryDaoSqls.SELECT_CATEGORY;
import static kr.or.connect.boostcourse.dao.CategoryDaoSqls.SELECT_COUNT;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.boostcourse.dto.Category;

@Repository
public class CategoryDao {
	private NamedParameterJdbcTemplate jdbc;
	
	public CategoryDao(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Category> selectAll(){
		return jdbc.query(SELECT_CATEGORY, new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				int count = selectCount(rs.getInt("id"));
				category.setCount(count);
				return category;
			}
		});
	}
	
	//카테고리별 product 갯수
	public int selectCount(int categoryId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("category_id", categoryId);
		return jdbc.queryForObject(SELECT_COUNT, params, Integer.class);
	}
	
}
