package kr.or.connect.boostcourse.dao;

public class PromotionDaoSqls {
	/* promotion 전체 조회 */
	public static final String SELECT_ALL = "SELECT p.id, p.product_id, fi.save_file_name AS product_image_url \n"
			+ "FROM promotion p LEFT JOIN product_image pi2 ON p.product_id = pi2.product_id\n"
			+ "	 LEFT JOIN file_info fi ON pi2.file_id = fi.id \n"
			+ "WHERE pi2.type ='th'";
}
