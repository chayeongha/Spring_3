package com.cyh.s3.dao.board;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cyh.s3.model.board.NoticeVO;
import com.cyh.s3.util.Pager;



@Repository 
public class NoticeDAO {
	
	//sqlSession 주입
	@Inject
	private SqlSession sqlSession;
	
	//final은 상수이므로  대문자로 사용
	//어느맵퍼의 무엇을 실행할지 
	private static final String NAMESPACE = "noticeMapper.";
	
	//delete
	public int noticeDelete(int num) throws Exception{
			
		return sqlSession.delete(NAMESPACE+ "noticeDelete", num);
	}
	
	//insert
	public int noticeWrite(NoticeVO noticeVO) throws Exception{
	
	//자체 int값을 리턴.
	return sqlSession.insert(NAMESPACE+"noticeWrite", noticeVO);
		
	}
	
	
	//selectone
	public NoticeVO noticeSelect(int num) throws Exception{
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("num",num );
		
		return sqlSession.selectOne(NAMESPACE+ "noticeSelect" , map);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//list
	public List<NoticeVO> noticeList(Pager pager) throws Exception{
		
	return sqlSession.selectList(NAMESPACE+"noticeList", pager);
		
	}
	
	//list count
	public int noticeCount(Pager pager) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"noticeCount", pager);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//update
	public int noticeUpdate(NoticeVO noticeVO)throws Exception {
	  
		  return sqlSession.update(NAMESPACE+"noticeUpdate" , noticeVO);
	  }
	
	//delete
	public int noticeDelete(NoticeVO noticeVO) throws Exception{
		
		return sqlSession.delete(NAMESPACE+"noticeDelete" , noticeVO);
		
	}
	
	
}
