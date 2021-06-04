package kr.or.connect.boostcourse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.boostcourse.dto.CommentImages;
import kr.or.connect.boostcourse.dto.Comments;

import static kr.or.connect.boostcourse.dao.CommentDaoSqls.*;

@Repository
public class CommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<CommentImages> rowMapperCommentImages = BeanPropertyRowMapper.newInstance(CommentImages.class);
	
	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Comments> selectComments(int displayInfoId){
		Map<String, Integer> params = new HashMap<>();
		params.put("display_info_id", displayInfoId);
		return jdbc.query(SELECT_COMMENTS, params, new RowMapper<Comments>() {

			@Override
			public Comments mapRow(ResultSet rs, int rowNum) throws SQLException {
				Comments dto = new Comments();
				dto.setComment(rs.getString("comment"));
				dto.setCommentId(rs.getInt("comment_id"));
				dto.setCreateDate(rs.getString("create_date"));
				dto.setModifyDate(rs.getString("modify_date"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setReservationDate(rs.getString("reservation_date"));
				dto.setReservationInfoId(rs.getInt("reservation_info_id"));
				dto.setReservationName(rs.getString("reservation_name"));
				dto.setReservationEmail(rs.getString("reservation_email"));
				dto.setReservationTelephone(rs.getString("reservation_telephone"));
				dto.setScore(rs.getInt("score"));
				dto.setCommentImages(selectCommentImages(rs.getInt("comment_id")));
				return dto;
			}
			
		});
	}
	
	public List<CommentImages> selectCommentImages(int reservationUserCommentId){
		Map<String, Integer> params = new HashMap<>();
		params.put("reservation_user_commet_id", reservationUserCommentId);
		return jdbc.query(SELECT_COMMENT_IMAGES, params, rowMapperCommentImages);
	}
	
	public double selectAvgScore(int displayInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("display_info_id", displayInfoId);
		
		try {
			return jdbc.queryForObject(AVG_SCORE, params, Double.class);
		}
		catch(EmptyResultDataAccessException e) {
			return 0;
		}
	}
}
