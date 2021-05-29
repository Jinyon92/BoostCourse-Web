package kr.or.connect.boostcourse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.boostcourse.dao.CommentDao;
import kr.or.connect.boostcourse.dto.Comments;
import kr.or.connect.boostcourse.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentDao commentDao;
	
	@Override
	public List<Comments> getComments(int displayInfoId) {
		return commentDao.selectComments(displayInfoId);
	}

	@Override
	public double getAvgScore(int displayInfoId) {
		return commentDao.selectAvgScore(displayInfoId);
	}

}
