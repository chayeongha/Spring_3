package com.cyh.s3.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cyh.s3.dao.board.NoticeDAO;
import com.cyh.s3.model.board.NoticeVO;
import com.cyh.s3.util.Pager;


@Service
public class NoticeService {


	@Inject
		private NoticeDAO noticeDAO;
	
	
		public int noticeUpdate(NoticeVO noticeVO) throws Exception{
			
			return noticeDAO.noticeUpdate(noticeVO);
		}
		
	
		public int noticeDelete(int num) throws Exception{
			
		return	noticeDAO.noticeDelete(num);
			
		}
		
		
		
		
		public int noticeWrite(NoticeVO noticeVO) throws Exception{
			
			
		return	noticeDAO.noticeWrite(noticeVO);
			
		}
		
		
		
		public NoticeVO  noticeSelect(int num) throws Exception{
			
			
		return	noticeDAO.noticeSelect(num);
			
		}
	
		
		
		//curPage매개변수를 받는다
		public List<NoticeVO> noticeList(Pager pager)throws Exception{
			//pager방식
			
			pager.makeRow();
				
			
			pager.makePage(noticeDAO.noticeCount(pager));
		
			return noticeDAO.noticeList(pager);
		}
		
		
		
		
		
}
