package com.cyh.s3.dao.board;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cyh.s3.model.board.QnaVO;

@Repository
public class QnaDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE= "qnaMapper";
	
	//list
	public List<QnaVO> qnaList(Map<String, Integer>map)throws Exception{
		
		
		
		return sqlSession.selectList(NAMESPACE+"qnaList" ,map);
	}

}
