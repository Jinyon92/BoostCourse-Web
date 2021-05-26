package kr.or.connect.boostcourse.dao;

import static kr.or.connect.boostcourse.dao.ProductDaoSqls.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.boostcourse.dto.DisplayInfo;
import kr.or.connect.boostcourse.dto.DisplayInfoImage;
import kr.or.connect.boostcourse.dto.Product;
import kr.or.connect.boostcourse.dto.ProductImages;
import kr.or.connect.boostcourse.dto.ProductPrices;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> rowMapperProduct = BeanPropertyRowMapper.newInstance(Product.class);
	private RowMapper<ProductImages> rowMapperProductImages = BeanPropertyRowMapper.newInstance(ProductImages.class);
	private RowMapper<ProductPrices> rowMapperProductPrices = BeanPropertyRowMapper.newInstance(ProductPrices.class);
	private RowMapper<DisplayInfoImage> rowMapperDisplayInfoImage = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	private RowMapper<DisplayInfo> rowMapperDisplayInfo = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	/* 전체 product 조회 */
	public List<Product> selectAll(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_ALL, params, rowMapperProduct);
	}
	
	/* 카테고리별 product 조회 */
	public List<Product> selectByCategory(Integer categoryId, Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("category_id", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_BY_CATEGORY, params, rowMapperProduct);
	}
	
	/* 전체 product 갯수 */
	public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}
	
	/* productImages 조회 */
	public List<ProductImages> selectProductImages(int displayInfoId){
		Map<String, Integer> params = new HashMap<>();
		params.put("display_info_id", displayInfoId);
		return jdbc.query(SELECT_PRODUCT_IMAGES, params, rowMapperProductImages);
	}
	
	/* productPrices 조회 */
	public List<ProductPrices> selectProductPrices(int displayInfoId){
		Map<String, Integer> params = new HashMap<>();
		params.put("display_info_id", displayInfoId);
		return jdbc.query(SELECT_PRODUCT_PRICES, params, rowMapperProductPrices);
	}
	
	/* displayInfoImage 조회 */
	public List<DisplayInfoImage> selectDisplayInfoImage(int displayInfoId){
		Map<String, Integer> params = new HashMap<>();
		params.put("display_info_id", displayInfoId);
		return jdbc.query(SELECT_DISPLAY_INFO_IMAGE, params, rowMapperDisplayInfoImage);
	}
	
	/* displayInfo 조회 */
	public DisplayInfo selectDisplayInfo(int displayInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("display_info_id", displayInfoId);
		return jdbc.queryForObject(SELECT_DISPLAY_INFO, params, rowMapperDisplayInfo);
	}
}
