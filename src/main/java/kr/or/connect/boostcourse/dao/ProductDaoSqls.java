package kr.or.connect.boostcourse.dao;

public class ProductDaoSqls {
	/* 전체 product 갯수 */
	public static final String SELECT_COUNT = "SELECT count(*) \n"
			+ "FROM product p LEFT JOIN display_info di ON p.id = di.product_id";
	
	/* 전체 product 조회 */
	public static final String SELECT_ALL = "SELECT di.id display_info_id, p.id product_id ,di.place_name, p.content product_content, p.description product_description,fi.save_file_name product_image_url \n"
			+ "FROM product p LEFT JOIN display_info di ON p.id = di.product_id\n"
			+ "	 LEFT JOIN product_image pi2 ON p.id = pi2.product_id \n"
			+ "	 LEFT JOIN file_info fi ON pi2.file_id = fi.id \n"
			+ "WHERE pi2.type = 'th' \n"
			+ "ORDER BY p.id ASC limit :start, :limit";
	
	/* 카테고리별 product 조회 */
	public static final String SELECT_BY_CATEGORY = "SELECT di.id display_info_id, p.id product_id ,di.place_name, p.content product_content , p.description product_description,fi.save_file_name product_image_url \n"
			+ "FROM product p LEFT JOIN display_info di ON p.id = di.product_id\n"
			+ "	 LEFT JOIN product_image pi2 ON p.id = pi2.product_id \n"
			+ "	 LEFT JOIN file_info fi ON pi2.file_id = fi.id \n"
			+ "WHERE pi2.type = 'th'\n"
			+ "AND p.category_id = :category_id\n"
			+ "ORDER BY p.id ASC limit :start, :limit";
	
}
