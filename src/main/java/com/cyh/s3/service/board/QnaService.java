package com.cyh.s3.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cyh.s3.dao.board.QnaDAO;
import com.cyh.s3.model.board.QnaVO;
import com.cyh.s3.util.Pager;


@Service
public class QnaService {
		
	
	@Inject
	private QnaDAO qnaDAO;
	
	
	
	//qnaList 
	public List<QnaVO> qnaList(Pager pager) throws Exception{
		//db보내기위해서  rownum을 계산.
		
		pager.makeRow();
		
		//int count=qnaDAO.qnaCount();
		pager.makePage(qnaDAO.qnaCount());
		
		return qnaDAO.qnaList(pager);
		
		
	}
	
	
	
	
	
	
}
