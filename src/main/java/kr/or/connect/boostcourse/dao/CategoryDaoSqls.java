package kr.or.connect.boostcourse.dao;

public class CategoryDaoSqls {
	/* 카테고리 조회 */ 
	public static final String SELECT_CATEGORY = "SELECT id ,name FROM category ";
	
	/* 카테고리별 product 갯수 */
	public static final String SELECT_COUNT = "SELECT count(*) \n"
			+ "FROM product p INNER JOIN display_info di ON p.id = di.product_id\n"
			+ "WHERE p.category_id = :category_id";
}
