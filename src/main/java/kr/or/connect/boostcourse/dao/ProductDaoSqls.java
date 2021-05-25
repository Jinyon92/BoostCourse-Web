package kr.or.connect.boostcourse.dao;

public class ProductDaoSqls {
	/* 전체 product 갯수 */
	public static final String SELECT_COUNT = "SELECT count(*) \n"
			+ "FROM product p LEFT JOIN display_info di ON p.id = di.product_id";
	
	/* 전체 product 조회 */
	public static final String SELECT_ALL = "SELECT di.id display_info_id, p.id product_id ,di.place_name, p.content product_content, p.description product_description,fi.save_file_name product_image_url \n"
			+ "FROM product p LEFT JOIN display_info di ON p.id = di.product_id\n"
			+ "	 INNER JOIN product_image pi2 ON p.id = pi2.product_id \n"
			+ "	 INNER JOIN file_info fi ON pi2.file_id = fi.id \n"
			+ "WHERE pi2.type = 'th' \n"
			+ "ORDER BY p.id limit :start, :limit";
	
	/* 카테고리별 product 조회 */
	public static final String SELECT_BY_CATEGORY = "SELECT di.id display_info_id, p.id product_id ,di.place_name, p.content product_content , p.description product_description,fi.save_file_name product_image_url \n"
			+ "FROM product p LEFT JOIN display_info di ON p.id = di.product_id\n"
			+ "	 INNER JOIN product_image pi2 ON p.id = pi2.product_id \n"
			+ "	 INNER JOIN file_info fi ON pi2.file_id = fi.id \n"
			+ "WHERE pi2.type = 'th'\n"
			+ "AND p.category_id = :category_id\n"
			+ "ORDER BY p.id limit :start, :limit";
	
	public static final String SELECT_PRODUCT_PRICES = "SELECT pp.id AS product_price_id ,pp.product_id ,pp.price_type_name ,pp.price ,pp.discount_rate ,pp.create_date ,pp.modify_date \n"
			+ "FROM product_price pp INNER JOIN display_info di ON pp.product_id = di.product_id \n"
			+ "WHERE di.id = :display_info_id";
	
	public static final String SELECT_PRODUCT_IMAGES = "SELECT fi.content_type ,fi.create_date ,fi.delete_flag ,fi.id AS file_info_id ,fi.file_name ,fi.modify_date ,img.product_id ,img.id as product_image_id ,fi.save_file_name ,img.type \n"
			+ "FROM product_image img INNER JOIN display_info di ON img.product_id = di.product_id\n"
			+ "					      INNER JOIN file_info fi ON img.file_id = fi.id \n"
			+ "WHERE di.id = :display_info_id \n"
			+ "AND img.type IN ('ma', 'et')\n"
			+ "LIMIT 2";
	
	public static final String SELECT_DISPLAY_INFO_IMAGE = "SELECT fi.content_type ,fi.create_date ,fi.delete_flag ,img.display_info_id ,img.id AS display_info_image_id, fi.id AS file_id ,fi.file_name , fi.modify_date ,fi.save_file_name \n"
			+ "FROM display_info_image img INNER JOIN file_info fi ON img.file_id = fi.id \n"
			+ "WHERE img.display_info_id = :display_info_id";
	
	public static final String SELECT_DISPLAY_INFO = "SELECT c.id AS category_id ,c.name ,di.tel AS telephone ,di.id AS display_info_id, di.*, p.content AS product_content, p.description AS product_description, p.event AS product_event, p.id AS product_id\n"
			+ "FROM display_info di INNER JOIN product p ON di.product_id = p.id \n"
			+ "					    INNER JOIN category c ON c.id = p.category_id \n"
			+ "WHERE di.id = :display_info_id";
	
}
