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
	
	
	//qnaReply
	public int qnaReply(QnaVO qnaVO) throws Exception{
		//부모의 정보를 알아오자
		QnaVO parent	= qnaDAO.qnaSelect(qnaVO.getNum());//부모의글번호
		System.out.println(parent.getRef());
		int result	= qnaDAO.qnaReplyUpdate(parent);
		
		qnaVO.setRef(parent.getRef());
		qnaVO.setStep(parent.getStep()+1);
		qnaVO.setDepth(parent.getDepth()+1);
		
	    result =qnaDAO.qnaReply(qnaVO);
	    
	    return result;
		
	}
	
	
	//qnaSelect
	public QnaVO qnaSelect(int num) throws Exception{
		
		return qnaDAO.qnaSelect(num);
	}
	
	
	
	//qnaList 
	public List<QnaVO> qnaList(Pager pager) throws Exception{
		//db보내기위해서  rownum을 계산.
		
		pager.makeRow();
		
		//int count=qnaDAO.qnaCount();
		pager.makePage(qnaDAO.qnaCount(pager));
		
		return qnaDAO.qnaList(pager);
		
		
	}
	//qnaWrite
	public int qnaWrite(QnaVO qnaVO) throws Exception{
		return qnaDAO.qnaWrite(qnaVO);
	}
	
	
	
	
}
