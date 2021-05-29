package kr.or.connect.boostcourse.service;

import java.util.List;

import kr.or.connect.boostcourse.dto.Comments;

public interface CommentService {
	List<Comments> getComments(int displayInfoId);
	double getAvgScore(int displayInfoId);
}
