package com.cyh.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;

import com.cyh.s3.TestAbstractCase;
import com.cyh.s3.model.board.QnaVO;

public class QnaDAOTest extends TestAbstractCase{

	@Inject
	private QnaDAO qnaDAO;
	
	
	/* @Test */
	public void Test()throws Exception {
		
			this.qnaDAOTest();
		
	}
	
	private void qnaDAOTest() {
		
		assertNotNull(qnaDAO);
	}
	
	
	/* @Test */
	public void qnaListTest()throws Exception {
		//	List<QnaVO>	ar=qnaDAO.qnaList();
			//	assertNotEquals(0, ar.size());
				}

	
	@Test
	public void qnaInsertTest()throws Exception {
		for(int i=0; i<110; i++) {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setTitle("dued"+i);
			qnaVO.setWriter("cyh"+i);
			qnaVO.setContents("jaldml"+i);
			qnaDAO.qnaInsert(qnaVO);
			Thread.sleep(300);
		}

	}
	
	

}
