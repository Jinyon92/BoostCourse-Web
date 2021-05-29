package kr.or.connect.boostcourse.dao;

public class CommentSqls {
	
	public static final String SELECT_COMMENTS = "SELECT di.id AS display_id, ruc.comment ,ruc.id AS comment_id ,ruc.create_date ,ruc.modify_date ,ruc.product_id ,ri.reservation_date ,ri.reservation_email , ruc.reservation_info_id ,ri.reservation_name ,ri.reservation_tel AS reservation_telephone ,ruc.score \n"
			+ "FROM reservation_user_comment ruc INNER JOIN product p ON p.id = ruc.product_id \n"
			+ "								  INNER JOIN display_info di ON di.product_id = p.id \n"
			+ "								  INNER JOIN reservation_info ri ON ri.id = ruc.reservation_info_id \n"
			+ "WHERE di.id = :display_info_id";
	
	public static final String SELECT_COMMENT_IMAGES = "SELECT fi.content_type ,fi.create_date ,fi.modify_date ,fi.delete_flag ,ruci.file_id ,fi.file_name ,ruci.id AS image_id ,ruci.reservation_info_id ,ruci.reservation_user_comment_id ,fi.save_file_name \n"
			+ "FROM reservation_user_comment_image ruci INNER JOIN file_info fi ON ruci.file_id = fi.id \n"
			+ "WHERE ruci.reservation_user_comment_id = :reservation_user_commet_id";
	
	public static final String AVG_SCORE = "SELECT AVG(ruc.score) \n"
			+ "FROM reservation_user_comment ruc INNER JOIN product p ON p.id = ruc.product_id \n"
			+ "								  INNER JOIN display_info di ON di.product_id = p.id \n"
			+ "WHERE di.id = :display_info_id \n"
			+ "GROUP BY di.id";
}
