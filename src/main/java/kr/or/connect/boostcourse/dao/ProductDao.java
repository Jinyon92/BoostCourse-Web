package kr.or.connect.boostcourse.dao;

import static kr.or.connect.boostcourse.dao.ProductDaoSqls.SELECT_ALL;
import static kr.or.connect.boostcourse.dao.ProductDaoSqls.SELECT_BY_CATEGORY;
import static kr.or.connect.boostcourse.dao.ProductDaoSqls.SELECT_COUNT;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.boostcourse.dto.Product;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	/* 전체 product 조회 */
	public List<Product> selectAll(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_ALL, params, rowMapper);
	}
	
	/* 카테고리별 product 조회 */
	public List<Product> selectByCategory(Integer categoryId, Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("category_id", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_BY_CATEGORY, params, rowMapper);
	}
	
	/* 전체 product 갯수 */
	public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}
	
}
