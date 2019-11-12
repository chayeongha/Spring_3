package com.cyh.s3.dao.board;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cyh.s3.model.board.QnaVO;
import com.cyh.s3.util.Pager;

@Repository
public class QnaDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE="qnaMapper.";
	
	//list
	public List<QnaVO> qnaList(Pager pager)throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"qnaList", pager);
	}

	public int qnaCount(Pager pager) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"qnaCount",pager);
		
		
	}
	public int qnaInsert(QnaVO qnaVO ) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"qnaInsert", qnaVO);
				
		
	}
	
}
