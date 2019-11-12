package com.cyh.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.cyh.s3.TestAbstractCase;
import com.cyh.s3.model.board.NoticeVO;
import com.cyh.s3.util.Pager;

public class NoticeDAOTest extends TestAbstractCase {
	
	
	@Inject
	private NoticeDAO noticeDAO;
	

	//noticecount
	/* @Test */
	public void noticeCountTest(Pager pager)throws Exception{
		
	int count=noticeDAO.noticeCount(pager);
	assertEquals(140, count);
	}
	
	
	
	
	/* @Test */
	public void checkDAO() throws Exception{
		
		assertNotNull(noticeDAO);
		
	}
	
	
	
	
	

	
	/* @Test */
	public void noticeWriteTest() throws Exception{

	for(int i=0;i<110;i++) {
		
	NoticeVO noticeVO = new NoticeVO();

	noticeVO.setTitle("nt"+i);
	
	noticeVO.setWriter("df"+i);
	
	noticeVO.setContents("te"+i);
	
	int result= noticeDAO.noticeWrite(noticeVO);
	
		}
	/*assertEquals(1, result);*/
	
	}
	
	
	
	/* @Test */
	public void noticeDelete() throws Exception{
		
	int result	=noticeDAO.noticeDelete(3);
		
	
	assertEquals(1, result);
	
	
	}
	
	
	
	
	/* @Test */
	public void noticeUpdate() throws Exception{
		
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setTitle("dfd");
		noticeVO.setWriter("df");
		noticeVO.setContents("dfdf");
		noticeVO.setNum(3);
		
		int result =  noticeDAO.noticeUpdate(noticeVO);
		assertEquals(1, result);
	}
	
	
	
	
	
	/* @Test */
	public void noticeDeleteTest()throws Exception {
		
		int result = noticeDAO.noticeDelete(1);
		assertEquals(1, result);
	}
	
	
	/* @Test */
	public void noticeSelectTest() throws Exception{
		
		NoticeVO noticeVO=noticeDAO.noticeSelect(1);
		
		assertNotNull(noticeVO);
		
	}
	
	/* @Test */
	public void noticeListTest()throws Exception{
		List<NoticeVO> ar = noticeDAO.noticeList();
		
		assertNotNull(ar.size());
	
	}
	
	
	
	
	
	
}
